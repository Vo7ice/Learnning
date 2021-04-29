function createFunctions() {
    var result = new Array();
    for (var i = 0;i < 10; i++) {
        result[i] = function() {
            return i;
        };
    }
    return result;
}

var name = "The window";
var object = {
    name : "My Object",

    getNameFunc : function(){
        return function() {
            return this.name;
        };
    }
};

console.log("object.getNameFunc() :: " + object.getNameFunc()());

var object1 = {
    name : "My Object",
    getNameFunc : function() {
        var that = this;
        return function() {
            return that.name;
        };
    }
};
console.log("object1.getNameFunc() :: " + object1.getNameFunc()());

// function assignHandler() {
//     var element = document.getElementById("button");
//     element.onlick = function() {
//         alert(element.id);
//     }
// };

// assignHandler();
// 静态私有变量
(function() {
    var name = "";
    Person = function(value) {
        name = value;
    };
    Person.prototype.getName = function() {
        return name;
    };
    Person.prototype.setName = function(value) {
        name = value;
    };
})();

var person1 = new Person("Nicholas");
console.log("Person1 name :: " + person1.getName());
person1.setName("Greg");
console.log("Person1 name :: " + person1.getName());

var person2 = new Person("Michael");
console.log("Person2 name :: " + person2.getName());
console.log("Person1 name :: " + person1.getName());

// 模块模式
var singleton = {
    name: value,
    method:function() {
        
    }
};

var singleton1 = function() {
    var privateViriable = 10;

    function privateFunction() {
        return false;
    }
}