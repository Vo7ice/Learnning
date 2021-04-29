var person = {
    name: "Nicholas",
    age: 29,
    job: "Software Engineer",

    sayName: function() {
        console.log("person.name :: " + this.name);
    }
};

Object.defineProperty(person, "name", {
    configurable: false,
    value: "Nicholas"
});

var book = {
    _year: 2004,
    edition: 1
};

Object.defineProperty(book, "year", {
    get: function() {
        return this._year;
    },
    set: function(newValue) {
        this._year = newValue;
        this.edition += newValue -2004;
    }
});

book.year = 2005;
console.log("book edition :: " + book.edition);
var descriptor = Object.getOwnPropertyDescriptor(book, "_year");
console.log("book descriptor.value :: " + descriptor.value);
console.log("book descriptor.configurable :: " + descriptor.configurable);
// 创建对象
// 工厂模式
function createPerson(name, age, job) {
    var o = new Object();
    o.name = name;
    o.age = age;
    o.job = job;
    o.sayName = function() {
        console.log("name :: " + this.name);
        return this.name;
    };
    o.toString = function() {
        console.log("name :: " + this.name + ", age :: " + this.age + ", job :: " + this.job);
        return "name :: " + this.name + ", age :: " + this.age + ", job :: " + this.job;
    };
    return o;
}

var person1 = createPerson("Nicholas", 29, "Software Engineer");
var person2 = createPerson("Greg", 27, "Doctor");
console.log("person1 :: " + person1.toString() + ", person2 :: " + person2.sayName());
// 构造函数模式
class Person1 {
    constructor(name, age, job) {
        this.name = name;
        this.age = age;
        this.job = job;
        // this.sayName = function () {
        //     console.log("name :: " + this.name);
        //     return this.name;
        // };
        this.sayName = new Function("alert(this.name)");
    }
}
var person1 = new Person1("Nicholas", 29, "Software Engineer");
console.log(Person1.prototype.isPrototypeOf(person1));
class Person2 {
    constructor() {
    }
}
Person2.prototype.name = "Nicholas";
Person2.prototype.age = 29;
Person2.prototype.job = "Software Engineer";
Person2.prototype.sayName = function() {
    alert(this.name);
};

var person1 = new Person2();
var person2 = new Person2();
console.log("constructor person1.hasOwnProperty(name) = " + person1.hasOwnProperty("name"));
person1.name = "Greg";
console.log("set value person1.hasOwnProperty(name) = " + person1.hasOwnProperty("name"));
delete person1.name;
console.log("delete value person1.hasOwnProperty(name) = " + person1.hasOwnProperty("name"));
// in 操作符
class Person3 {

}

Person3.prototype.name = "Nicholas";
Person3.prototype.age = 29;
Person3.prototype.job = "Software Engineer";
Person3.prototype.sayName = function() {
    alert(this.name);
};

var person3 = new Person3();
var person4 = new Person3();
console.log("person3 has ownProperty(name) :: " + person3.hasOwnProperty("name"));
console.log("name in person3 :: " + ("name" in person3));

person3.name = "Greg";
console.log("person3 set name");
console.log("from constructor :: " + person3.name);
console.log("person3 has ownProperty(name) :: " + person3.hasOwnProperty("name"));
console.log("name in person3 :: " + ("name" in person3));
delete person3.name;
console.log("person3 delete name");
console.log("from constructor :: " + person3.name);
console.log("person3 has ownProperty(name) :: " + person3.hasOwnProperty("name"));
console.log("name in person3 :: " + ("name" in person3));

var keys = Object.keys(Person3.prototype);// 返回所有课枚举属性的字符串数组
console.log("Person3 prototype keys :: " + keys);

var p1 = new Person3();
p1.name = "Rob";
p1.age = 31;
var p1keys = Object.keys(p1);
console.log("p1 keys :: " + p1keys);

// 组合使用构造函数模式和原型模式
class Person4 {
    constructor(name, age, job) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.friends = ["Shelby", "Court"];
    }
}

Person4.prototype = {
    constructor : Person4,
    sayName : function() {
        alert(this.name);
    }
}

var persona = new Person4("Nicholas", 29, "Software Engineer");
var personb = new Person4("Greg", 27, "Doctor");
persona.friends.push("Van");
console.log("persona friends :: "+ persona.friends);
console.log("personb friends :: "+ personb.friends);
console.log("person friends is equal :: "+ (persona.friends === personb.friends));

// 寄生构造函数模式
function SpecialArray() {
    var values = new Array();
    values.push.apply(values, arguments);
    values.toPipedString = function() {
        return this.join("|");
    };
    return values;
}

var colors = new SpecialArray("red", "blue", "green");
console.log("colors.toPipedString :: " + colors.toPipedString());

// 继承
// 原型链
class SuperType {
    constructor() {
        this.property = true;
        this.getSuperValue = function() {
            return this.property;
        }
    }
}

class SubType extends SuperType{
    constructor() {
        super();
        this.subproperty = false;
        this.getSubValue = function() {
            return this.subproperty;
        };
        this.getSuperValue = function() {
            return false;
        }
        this.someOtherMethod = function() {
            return false;
        }
    }
}

var instance = new SubType();
console.log("instance getSuperValue :: " + instance.getSuperValue());

class Animal {
    constructor(height, weight) {
        this.height = height;
        this.weight = weight;
    }
    static getsomething () {
        console.log("static func :: " + this.feature);
    }
}
Animal.feature = "staticAttrs";
Animal.getsomething();

class Dog extends Animal {
    constructor(color, height, weight) {
        super(height, weight);
        this.color = color;
    }
}
var dog = new Dog("red", 1, 2);

console.log("dog instanceof Dog :: " + (dog instanceof Dog));
console.log("dog instanceof Animal :: " + (dog instanceof Animal));
