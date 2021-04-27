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