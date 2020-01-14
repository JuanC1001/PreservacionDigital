/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var BrowserDetect = {
    init: function () {
        this.browser = this.searchString(this.dataBrowser) || "An unknown browser";
        this.version = this.searchVersion(navigator.userAgent)
        || this.searchVersion(navigator.appVersion)
        || "an unknown version";
        this.OS = this.searchString(this.dataOS) || "an unknown OS";
    },
    searchString: function (data) {
        for (var i=0;i<data.length;i++)	{
            var dataString = data[i].string;
            var dataProp = data[i].prop;
            this.versionSearchString = data[i].versionSearch || data[i].identity;
            if (dataString) {
                if (dataString.indexOf(data[i].subString) != -1)
                    return data[i].identity;
            }
            else if (dataProp)
                return data[i].identity;
        }
    },
    searchVersion: function (dataString) {
        var index = dataString.indexOf(this.versionSearchString);
        if (index == -1) return;
        return parseFloat(dataString.substring(index+this.versionSearchString.length+1));
    },
    dataBrowser: [
    {
        string: navigator.userAgent,
        subString: "OmniWeb",
        versionSearch: "OmniWeb/",
        identity: "OmniWeb"
    },
    {
        string: navigator.vendor,
        subString: "Apple",
        identity: "Safari"
    },
    {
        prop: window.opera,
        identity: "Opera"
    },
    {
        string: navigator.vendor,
        subString: "iCab",
        identity: "iCab"
    },
    {
        string: navigator.vendor,
        subString: "KDE",
        identity: "Konqueror"
    },
    {
        string: navigator.userAgent,
        subString: "Firefox",
        identity: "Firefox"
    },
    {
        string: navigator.vendor,
        subString: "Camino",
        identity: "Camino"
    },
    {		// for newer Netscapes (6+)
        string: navigator.userAgent,
        subString: "Netscape",
        identity: "Netscape"
    },
    {
        string: navigator.userAgent,
        subString: "MSIE",
        identity: "Explorer",
        versionSearch: "MSIE"
    },
    {
        string: navigator.userAgent,
        subString: "Gecko",
        identity: "Mozilla",
        versionSearch: "rv"
    },
    { 		// for older Netscapes (4-)
        string: navigator.userAgent,
        subString: "Mozilla",
        identity: "Netscape",
        versionSearch: "Mozilla"
    }
    ],
    dataOS : [
    {
        string: navigator.platform,
        subString: "Win",
        identity: "Windows"
    },
    {
        string: navigator.platform,
        subString: "Mac",
        identity: "Mac"
    },
    {
        string: navigator.platform,
        subString: "Linux",
        identity: "Linux"
    }
    ]

};
BrowserDetect.init();

var tipo_browser = new Array();
function add_browser (nombre, version, flag) {
    if (!tipo_browser[nombre]) tipo_browser[nombre] = new Array();
    tipo_browser[nombre][version] = flag;
    return;
}

var cli_browser = BrowserDetect.browser;
var cli_version = BrowserDetect.version; 
var cli_os = BrowserDetect.OS;

if (cli_browser == 'Firefox') cli_version = '3'; /* No se validará el número de versión del browser cuando sea firefox */

add_browser(cli_browser,cli_version,false);
add_browser('Firefox','3',true);
add_browser('Firefox','3.5',true);
add_browser('Firefox','3.6',true);
add_browser('Firefox','6',true);
add_browser('Firefox','7',true);


