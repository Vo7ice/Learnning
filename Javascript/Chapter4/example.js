function myFunction() {
    var person = new Object();
    person.name = "Nicholas";
    alert(person.name);
}

var color = "blue";
function changeColor() {
    if (color === "blue") {
        color = "red";
    } else {
        color = "blue";
    }
    alert("Color is " + color);
}

function getColor() {
    function getColorInFunction() {
        var color = "red";
        return color;
    }
    alert("Color is " + getColorInFunction());
}