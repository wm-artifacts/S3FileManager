/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
};
Page.rootPath = null;
Page.anchor2Click = function($event, widget) {
    let text = widget.context.item.key;
    if (navigator.clipboard) {
        navigator.clipboard.writeText(text).then(() => {}).catch(err => {
            console.error('Could not copy text: ', err);
        });
    }
};

Page.isImage = function(key) {
    let isImage = [".svg", ".ico", ".gif", ".jpg", ".png", ".jpeg", ".apng", ".avif", ".webp", ".bmp", ".tiff"].some((i) => key.includes(i));
    return isImage;
}

Page.listRootLevelFoldersObjectsList1Dblclick = function($event, widget) {
    if (widget.item.size === 0) {
        Page.rootPath = widget.item.key;
        invokeJsGetFolderContentsApi(Page.rootPath);
    }
};

Page.buttonBackClick = function($event, widget) {
    //debugger
    Page.count = Page.count - 1;
    Page.rootPath = removeLastElement(Page.rootPath);
    if (Page.rootPath === '') {

        Page.Variables.jsGetS3RootLevelObjects.invoke();

    } else {
        invokeJsGetFolderContentsApi(Page.rootPath);
    }
};

function invokeJsGetFolderContentsApi(path) {
    Page.Variables.jsGetFolderContents.invoke({
        inputFields: {
            "folderPath": path
        }
    }, function(data) {
        //debugger
        data = data.filter((item) => item.key !== Page.rootPath);
        Page.Variables.jsGetS3RootLevelObjects.dataSet = data;
        Page.Widgets.listRootLevelFoldersObjectsList1.dataset = data;
    })
};


Page.jsCreateS3FolderonSuccess = function(variable, data) {
    invokeJsGetFolderContentsApi(Page.rootPath);
};

Page.jsUploadFilesToS3onSuccess = function(variable, data) {
    invokeJsGetFolderContentsApi(Page.rootPath);
};

Page.jsDeleteS3FileonSuccess = function(variable, data) {
    invokeJsGetFolderContentsApi(Page.rootPath);
};

function removeLastElement(path) {
    if (path.endsWith('/')) {
        path = path.slice(0, -1);
    }
    const lastSlashIndex = path.lastIndexOf('/');
    if (lastSlashIndex === -1) {
        return '';
    }
    const newPath = path.substring(0, lastSlashIndex + 1);
    return newPath || '';
};
