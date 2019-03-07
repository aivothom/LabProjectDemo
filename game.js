var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
ctx.fillStyle = "#FFFFFF";
ctx.fillRect(0, 0, canvas.width, canvas.height);

function drawGrid(size) {

    ctx.lineWidth = 1;
    ctx.strokeStyle = "#99bbe0";
    ctx.moveTo(0, 0);
    var x = 0;
    while (x < canvas.width) {
        ctx.lineTo(x, canvas.height);
        ctx.stroke();
        x += size;
        ctx.moveTo(x, 0);
    }
    ctx.moveTo(0, 0);
    var y = 0;
    while (y < canvas.height) {
        ctx.lineTo(canvas.width, y);
        ctx.stroke();
        y += size;
        ctx.moveTo(0, y);
    }

}

function getRandomArbitrary(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}
function makeRandomPlayers() {
    ctx.fillStyle = "#FF0000";
    locationsDict = {"x": [], "y": []};
    var i = 0;
    while (i < 20) {
        var x = getRandomArbitrary(0, canvas.width / squareSize) * squareSize;
        var y = getRandomArbitrary(0, canvas.height / squareSize) * squareSize;
        var lowX = x - squareSize;
        var highX = x + squareSize;
        var lowY = y - squareSize;
        var highY = y + squareSize;
        xPositions = locationsDict["x"];
        yPositions = locationsDict["y"];
        if ((xPositions.includes(lowX) || xPositions.includes(highX) || xPositions.includes(x)) && (yPositions.includes(lowY) || yPositions.includes(highY) || yPositions.includes(y))) {
        }
        else {
            xPositions.push(x);
            yPositions.push(y);
            i += 1
        }

        }

        for (i = 0; i < locationsDict["x"].length; i += 1) {
            var xDraw = locationsDict["x"][i];
            var yDraw = locationsDict["y"][i];
            ctx.fillRect(xDraw, yDraw, squareSize, squareSize);
        }
    }

function makeOneRandomPlayer() {
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");
    drawGrid(20);
    var r = getRandomArbitrary(0, 255).toString();
    var g = getRandomArbitrary(0, 255).toString();
    var b = getRandomArbitrary(0, 255).toString();
    ctx.fillStyle = "rgba("+r+", "+g+", "+b+", 1.0)";
    var squareSize = 20;
    var x = getRandomArbitrary(0, canvas.width / squareSize) * squareSize;
    var y = getRandomArbitrary(0, canvas.height / squareSize) * squareSize;
    ctx.fillRect(x, y, squareSize, squareSize);
    ctx.strokeStyle = "#000000";
    ctx.strokeRect(x, y, squareSize, squareSize);
}
