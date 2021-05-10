
function myFunction() {
    console.log("Vo7ice");
}

function displayInfo(args) {
    var output = "";
    if (typeof args.name == "string") {
        output += "Name: " + args.name + "\n";
    }

    if (typeof args.age == "number") {
        output += "Age: " + args.age + "\n";
    }

    console.log(output);
}

displayInfo({
    name: "Nicholas",
    age: 29
});

displayInfo({
    name: "Greg"
});

var colors = ["red", "blue", "green"];
colors[2] = "black";
colors[3] = "brown";
var name = [];
console.log(colors[3]);
console.log(colors.length);
console.log(name.length);

if (Array.isArray(colors)) {
    console.log("colors is array");
}

var colours = ["red", "blue", "green"];
console.log("toString:: " + colours.toString());
console.log("valueOf:: " + colours.valueOf());
console.log("colours:: " + colours);

var person1 = {
    toLocaleString : function() {
        return "Nikolaos";
    },
    toString: function() {
        return "Nicholas";
    }
};

var person2 = {
    toLocaleString : function() {
        return "Grigorios";
    },
    toString : function() {
        return "Greg";
    }
};

var people = [person1, person2];
console.log(people);
console.log(people.toString());
console.log(people.toLocaleString());

// 栈方法
var colors1 = new Array();
var count1 = colors1.push("red", "green");
console.log("栈方法:: count1 = " + count1);
count1 = colors1.push("black");
console.log("栈方法:: count1 = " + count1);
var item1 = colors1.pop();
console.log("栈方法:: pop item = " + item1);
console.log("栈方法:: length = " + colors1.length);
// 队列方法
var colors2 = new Array();
var count2 = colors2.push("red", "green");
console.log("队列方法:: count2 = " + count2);

count2 = colors2.push("black");
console.log("队列方法:: count2 = " + count2);

var item2 = colors2.shift();
console.log("队列方法:: shift item = " + item2);
console.log("队列方法:: length =" + colors2.length);

var colors3 = new Array();
var count3 = colors3.unshift("red", "green");
console.log("unshift:: count3 = " + count3 + ",colors = " + colors3);

count3 = colors3.unshift("black");
console.log("unshift:: count3 = " + count3 + ",colors = " + colors3);

var item3 = colors3.pop();
console.log("unshift:: item3 = " + item3);
console.log("unshift:: length =" + colors3.length);
// 重排序
var values = [1,2,3,4,5];
values.reverse();
console.log("排序 reverse:: " + values);

var values1 = [0,1,5,10,15];
values1.sort();
console.log("排序 sort:: " + values1);

function compare(value1, value2) {
    if (value1 < value2) {
        return -1;
    } else  if (value1 > value2) {
        return 1;
    } else {
        return 0;
    }
}

values1.sort(compare);
console.log("排序 compare sort:: " + values1);
// 操作方法
var colors4 = ["red", "green", "blue"];
var colors5 = colors4.concat("yellow", ["black", "brown"]);
console.log("操作方法 :: colors4 = " + colors4);
console.log("操作方法 :: colors5 = " + colors5);

var colors6 = ["red", "green", "blue", "yellow", "purple"];
var colors7 = colors6.slice(1);
var colors8 = colors6.slice(1, 4);
console.log("操作方法 :: colors7 = " + colors7);
console.log("操作方法 :: colors8 = " + colors8);

var colors9 = ["red", "green", "blue"];
var removed = colors9.splice(0,1);
console.log("操作方法 :: colors9 = " + colors9);
console.log("操作方法 :: removed = " + removed);

removed = colors9.splice(1, 0, "yellow", "orange");
console.log("操作方法 :: colors9 = " + colors9);
console.log("操作方法 :: removed = " + removed);

removed = colors9.splice(1, 1, "red", "purple");
console.log("操作方法 :: colors9 = " + colors9);
console.log("操作方法 :: removed = " + removed);

// 位置方法
var numbers = [1,2,3,4,5,4,3,2,1];

console.log("位置方法 :: indexOf(4) = " + numbers.indexOf(4));
console.log("位置方法 :: lastIndexOf(4) = " + numbers.lastIndexOf(4));

console.log("位置方法 :: indexOf(4, 4) = " + numbers.indexOf(4, 4));
console.log("位置方法 :: indexOf(4, 2) = " + numbers.indexOf(4, 2));
console.log("位置方法 :: lastIndexOf(4, 4) = " + numbers.lastIndexOf(4, 6));

var person3 = {name:"Nicholas"};
var person4 = [{name:"Nicholas"}];
var morePeople = [person3];

console.log("位置方法 :: people.indexOf(person) = " + people.indexOf(person3));
console.log("位置方法 :: morePeople.indexOf(person) = " + morePeople.indexOf(person3));

// 迭代方法
var everyResult = numbers.every(function(item, index, array) {
    return item > 2;
});
console.log("迭代方法 :: everyResult item > 2 = " + everyResult);
var someResult = numbers.some(function(item, index, array) {
    return item > 2;
});
console.log("迭代方法 :: someResult item > 2 = " + someResult);
var filterResult = numbers.filter(function(item, index, array) {
    return item > 2;
});
console.log("迭代方法 :: filterResult item > 2 = " + filterResult);
var mapResult = numbers.map(function(item, index, array) {
    return item * 2;
});
console.log("迭代方法 :: mapResult item * 2 = " + mapResult);
var filterAndMapResult = numbers.filter(function(item, index, array) {
    return item > 2;
}).map(function(item, index, array) {
    return item * 2;
});
console.log("迭代方法 :: filter map result item * 2 = " + filterAndMapResult);
var values = [1, 2, 3, 4, 5];
var sum = values.reduce(function(prev, cur, index, array) {
    return prev + cur;
});
console.log("归并方法 :: reduce result prev + cur = " + sum);
// date类型
var now = new Date();
var someDate = new Date(Date.parse("May 25, 2004"));
// GMT时间 2000-1-1午夜零时
var y2k = new Date(Date.UTC(2000, 0));
var allFives = new Date(2005,4,5,17,55,55);
console.log("Date :: now = " + now + ", someDate = " + someDate + ",y2k = " + y2k +",allFives = " + allFives);
// 正则类型
// var expression = / pattern / flags;

/**
 * 匹配字符串中所有"at"的实例
 */
var pattern1 = /at/g;

/**
 * 匹配第一个"bat"或"cat",不区分大小写
 */
var pattern2 = /[bc]at/i;

/**
 * 转义后需匹配\
 * 匹配第一个"[ba]t"或"[ca]t",不区分大小写
 */
 var pattern3 = /\[bc\]at/i;

/**
 * 匹配所有以"at"结尾的3个字符的组合，不区分大小写
 */
var pattern4 = /.at/gi

/**
 * 转义后需匹配字符.
 * 匹配所有以".at"结尾的3个字符的组合，不区分大小写
 */
var pattern5 = /\.at/gi

var re = null, i;
for(i = 0; i < 10; i++) {
    re = /cat/g;
    console.log("test result = " + re.test("catastrophe"));
}
for(i = 0; i < 10; i++) {
    re = new RegExp("cat", "g");
    console.log("test result = " + re.test("catastrophe"));
}

var text = "000-00-0000";
var pattern = /\d{3}-\d{2}-\d{4}/;
if (pattern.test(text)) {
    console.log("pattern was matched.");
}
var patternx = new RegExp("\\[bc\\]at", "gi");
console.log("patternx::" + patternx.toString());
var text1 = "this has been a short summer";
var patternx1 = /(.)hort/g;

if (patternx1.test(text1)) {
    console.log("pattern was matched input ::" + RegExp.input);
    console.log("pattern was matched leftContext ::" + RegExp.leftContext);
    console.log("pattern was matched rightContext ::" + RegExp.rightContext);
    console.log("pattern was matched lastMatch ::" + RegExp.lastMatch);
    console.log("pattern was matched lastParen ::" + RegExp.lastParen);
    console.log("pattern was matched multiline ::" + RegExp.multiline);
}
// Function类型
function callSomeFucntion(someFunction, someArgument) {
    return someFunction(someArgument);
}
function add10(num) {
    return num + 10;
}
var result1 = callSomeFucntion(add10, 10);
console.log("callSomeFucntion :: " + result1);

function factorial(num) {
    if (num <= 1) {
        return 1;
    } else {
        return num * arguments.callee(num - 1);
    }
}

window.color = "red";
var o = { color: "blue" };
function sayColor() {
    console.log("this.color :: " + this.color);
}
sayColor();
o.sayColor = sayColor;
o.sayColor();

function outer() {
    return inner();
}

function inner() {
    console.log("inner :: " + arguments.callee.caller);
}

outer();

// apply
function sum(num1, num2) {
    return num1 + num2;
}

// function callSum1(num1, num2) {
//     return sum.apply(this, );
// }

// function callSum2(num1, num2) {
//     return sum.apply([num1, num2]);
// }

// console.log("callSum1 :: " + callSum1(10, 10));
// console.log("callSum2 :: " + callSum2(10, 10));

sayColor.call(this);
sayColor.call(window);
sayColor.call(o);
var objectSayColor = sayColor.bind(o);
objectSayColor();

function htmlEscapte(text) {
    return text.replace(/[<>"&]/g, function(match, pos, originalText) {
        switch (match) {
            case "<":
                return "&lt;";
            case ">":
                return "&gt;";
            case "\"":
                return "&quot;";
            case "&":
                return "&amp;";
        }
    });
}

console.log("htmlEscape :: <p class=\"greeting\">Hello world!</p> = " 
    + htmlEscapte("<p class=\"greeting\">Hello world!</p>"));

var uri = "http://www.wrox.com/illegal value.htm#start";

console.log("encodeURI(uri) :: " + encodeURI(uri));
console.log("encodeURIComponent(uri) :: " + encodeURIComponent(uri));

var uri1 = "http%3A%2F%2Fwww.wrox.com%2Fillegal%20value.htm%23start";
console.log("decodeURI(uri) :: " + decodeURI(uri1));
console.log("decodeURIComponent(uri) :: " + decodeURIComponent(uri1));

// eval
var msg = "hello world";
// eval("alert(msg);");

let visitsCountMap = new WeakMap();

function countUser(user) {
    let count = visitsCountMap.get(user) || 0;
    visitsCountMap.set(user, count + 1);
}