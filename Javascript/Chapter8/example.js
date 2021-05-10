var leftPos = (typeof window.screenLeft == "number") ? 
                window.screenLeft : window.screenX;
var topPos = (typeof window.screenLeft == "number") ? 
                window.screenTop : window.screenY;

console.log("left::" + leftPos + ", topPos::" + topPos);
// window.moveTo(0,0);
// window.resizeTo(100,100);
var blocked = false;
try {
    var baiduWin = window.open("http://www.baidu.com/", "baiduWindow", "height=400,width=400,top=10,left=10,resizable=yes");
    if (baiduWin == null) {
        blocked = true;
    } else {
        baiduWin.resizeTo(500,500);
        baiduWin.moveTo(100,100);
    }
} catch(ex) {
    blocked = true;
}

if (blocked) {
    alert("The popup was blocked!")
}



var timeoutId = setTimeout(function() {
    alert("Hello wolrd!")
}, 1000);

clearTimeout(timeoutId);

var num = 0;
var max = 10;
var intervalid = null;
function incrementNumber() {
    num++;
    console.log("incrementNumber:: num = " + num);
    if (num == max) {
        clearInterval(intervalid);
        alert("Done");
    }
}

intervalid = setInterval(incrementNumber, 500);

if (confirm("Are you sure?")) {
    alert("I`m so glad you`re sure! ");
} else {
    alert("I`m sorry to hear you`re not sure. ");
}

var result = prompt("What is your name? ", "");
if (result != null) {
    alert("Welcome, " + result);
}

window.print();
window.find();

function getQueryStringArgs() {
    var qs = (location.search.length > 0 ? location.search.substring(1):""),
    args = {},
    items = qs.length ? qs.split("&"):[],
    item = null,
    name = null,
    value = null,
    i = 0,
    len = items.length;
    for (i=0; i < len; i++) {
        item = items[i].split("=");
        name = decodeURIComponent(item[0]);
        value = decodeURIComponent(item[1]);
        if (name.length) {
            args[name] = value;
        }
    }
    return args;
}

function hasIEPlugin(name) {
    try {
        new ActiveXObject(name);
        return true;
    } catch(ex) {
        return false;
    }
}

console.log("has ShockwaveFlash :: " + hasIEPlugin("ShockwaveFlash.ShockwaveFlash"));

console.log("has QuickTIme :: " +hasIEPlugin("QuickTIme.QuickTime"));

// function ask(question, yes, no) {
//     if (confirm(question)) yes()
//     else no();
//   }

let ask = (question, yes, no) => {
    if (confirm(question)) {
        yes();
    } else {
        no();
    }
}
  
  ask(
    "Do you agree?",
    function() { alert("You agreed."); },
    function() { alert("You canceled the execution."); }
  );