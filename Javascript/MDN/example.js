let user = new Object();
user.name = "John";
user.surname = "Smith";
user.name = "Pete";
delete user.name;

let isEmpty = (object) => {
    for (let key in object) {
        return false;
    }
    return true;
}

let sum_salary = (salaries) => {
    let sum = 0;
    if (isEmpty(salaries)) {
        return sum;
    } else {
        for (let key in salaries) {
            sum += salaries[key];
        }
        return sum;
    }
}

let salaries = {
    John:100,
    Ann:160,
    Pete:130
}

let empty_salaries = {}

console.log("sum_salary :: " + sum_salary(salaries));
console.log("sum_salary :: " + sum_salary(empty_salaries));

let menu = {
    width:200,
    height:300,
    title:"My menu"
}

let multiplyNumeric = (menu) => {
    for (let key in menu) {
        if (typeof menu[key] == "number") {
            menu[key] = menu[key] * 2;
        }
    }
}
multiplyNumeric(menu);
console.log("after change :: " + menu.width + ",height:" + menu.height + ",title:" + menu.title);

let user1 = { name: "John" };
let permissions1 = { canView:true };
let permissions2 = { canEdit:true };
Object.assign(user1, permissions1, permissions2);
// console.dir(user1);
// console.log("啥玩意儿啊" + JSON.stringify(user1))
let user2 = {
    name: "John",
    sizes: {
        height: 182,
        width: 50
    }
};

let clone2 = Object.assign({}, user2);
console.log(user2.sizes === clone2.size);

user2.sizes.width++;
console.log(clone2.sizes.width);

let user3 = { name: "John" };
let admin3 = { name: "Admin" };

function sayHi() {
    console.log( this.name );
}

user3.f = sayHi;
admin3.f = sayHi;

user3.f();
admin3.f();

admin3['f']();

function makeUser() {
    return {
        name : "John",
        ref() {
            this
        } 
    };
}

let user4 = makeUser();
// console.log( user4.ref().name );

let calculator = {
    read() {
        this.x = +prompt("input the first number", 0);
        this.y = +prompt("input the second number", 0);
    },
    sum() {
        if(typeof this.x == "number" && typeof this.y == "number") {
            console.log("sum:: x = " +  this.x + ",y = " +  this.y);
            return this.x + this.y;
        } else {
            return 0;
        }
    },
    mul() {
        if(typeof this.x == "number" && typeof this.y == "number") {
            console.log("mul:: x = " + this.x + ",y = " + this.y);
            return this.x * this.y;
        } else {
            return 0;
        }
    }
}
// calculator.read();
// console.log("sum() :: " + calculator.sum());
// console.log("mul() :: " + calculator.mul());

let ladder = {
    step: 0,
    up() {
        this.step++;
        return this;
    },
    down() {
        this.step--;
        return this;
    },
    showStep() {
        console.log(this.step);
        return this;
    }
}
ladder.up().up().down().showStep();

class Calculator1 {
    constructor() {
        this.read = function () {
            this.x = +prompt("input the first number", 0);
            this.y = +prompt("input the second number", 0);
        };
        this.sum = function () {
            return this.x + this.y;
        };
        this.mul = function () {
            return this.x * this.y;
        };
    }
}

class Accumulator {
    constructor(startingValue) {
        this.value = startingValue;
        this.read = function() {
            let number = +prompt("input the value", 0);
            this.value += number;
        }
    }
}

// let accumulator = new Accumulator(1);
// accumulator.read();
// accumulator.read();
// console.log("value:: " + accumulator.value);

let user5 = {
    name:"John",
    money:1000,

    [Symbol.toPrimitive](hint) {
        console.log("hint: " + hint);
        return hint == "string" ? `{name: "${this.name}}` : this.money;
    }
}

console.log(user5);
console.log(+user5);
console.log(user5 + 500);

function sum(...args) {
    let sum = 0;
    
    for (let arg of args) sum += arg;

    return sum;
}

// let user6 = {
//     sayHi = {

//     },

//     sayBye = {

//     }
// }

function ask(question, ...handlers) {
    let isYes = confirm(question);

    for (let handler of handlers) {
        if (handler.length == 0) {
            if (isYes) handler();
        } else {
            handler(isYes);
        }
    }
}

ask("Question?", () => alert('You said yes'), result => alert(result));

let func = new Function("a", "b", "return a + b");

console.log(func(1, 2));

let worker = {
    someMethod() {
        return 1;
    },
    slow(x) {
        console.log("Called with " + x);
        return x * this.someMethod(); // 缓存时 this.someMethod is not a function
    }
};

function cachingDecorator(func) {
    let cache = new Map();
    return function(x) {
        if (cache.has(x)) {
            return cache.get(x);
        }
        let result = func(this, x);
        cache.set(x, result);
        return result;
    };
}

worker.slow = cachingDecorator(worker.slow);

// alert(worker.slow(1));
// alert(worker.slow(2));

function sayHi2() {
    console.log("sayHi2::" + this.name);
}

let userxx = { name: "John"};
let admin = { name: "Admin"};
sayHi2.call(userxx);

let worker1 = {
    slow(min, max) {
        console.log(`Called with ${min}, ${max}`);
        return min + max;
    }
}

function cachingDecorator2(func, hash) {
    let cache = new Map();
    return function() {
        let key = hash(arguments);
        if (cache.has(key)) {
            return cache.get(key);
        }
        let result = func.call(this, ...arguments);

        cache.set(key, result);
        return result;
    };
}

function hash(args) {
    return args[0] + "," + args[1];
}

worker1.slow = cachingDecorator2(worker1.slow, hash);

console.log("worker.slow(3,5) = " + worker1.slow(3, 5));
console.log("Again worker.slow(3,5) = " + worker1.slow(3, 5));

let wrapper = function() {
    return func.apply(this, arguments);
}

function work(a, b) {
    return a + b;
}

work = spy(work);
work(1,2);
work(4,5);

for (let args of work.calls) {
    console.log(`Call: ` + args.join());
}

function spy(func) {
    function wrapper(...args) {
        wrapper.calls.push(args);
        return func.apply(this, args);
    }

    wrapper.calls = [];
    return wrapper;
}

function f(x) {
    console.log(`f: ` + x);
}

let f1000 = delay(f, 1000);
let f1500 = delay(f, 1500);

f1000("test");
f1500("test");

function delay(f, delay) {
    return function() {
        setTimeout(() => f.apply(this, arguments), delay);
    };
}

function debounce(handler, ms) {
    let timeout;
    return function() {
        clearTimeout(timeout);
        timeout = setTimeout(() => handler.apply(this, arguments), ms);
    };
}

function throttle(func, ms) {
    let isThrottled = false,
        savedArgs,
        savedThis;
    
    function wrapper() {
        if (isThrottled) {
            savedArgs = arguments;
            savedThis = this;
            return;
        }

        func.apply(this, arguments);
        isThrottled = true;
        setTimeout(function() {
            isThrottled = false;
            if (savedArgs) {
                wrapper.apply(savedThis, savedArgs);
                savedThis = savedArgs = null;
            }
        }, ms);
    }
    return wrapper;
}

function f1() {
    console.log("this function :: " + this);
}

let userss = {
    g: f1.bind(null)
};
userss.g();

function sayHi3() {
    console.log("sayHi3::" + this.name);
}
sayHi3.test = 5;

let bound = sayHi3.bind({
    name:"John"
});

console.log("bound.test :: " + bound.test);

function askPassword(ok, fail) {
    let password = prompt("Password?", '');
    if (password == "rockstar") ok();
    else fail();
  }
  
  let userq = {
    name: 'John',
  
    loginOk() {
      alert(`${this.name} logged in`);
    },
  
    loginFail() {
      alert(`${this.name} failed to log in`);
    },
  
  };
  
  askPassword(userq.loginOk.bind(userq), userq.loginFail.bind(userq));
