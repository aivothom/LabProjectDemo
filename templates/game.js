var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
ctx.fillStyle = "#FFFFFF";
ctx.fillRect(0, 0, canvas.width, canvas.height);

function drawGrid() {

    ctx.lineWidth = 1;
    ctx.strokeStyle = "#D1D1E0";
    squareSize = 20;
    var x = 0;
    while (x < canvas.width) {
        ctx.lineTo(x, canvas.height);
        ctx.stroke();
        x += squareSize;
        ctx.moveTo(x, 0);
    }
    ctx.moveTo(0, 0);
    var y = 0;
    while (y < canvas.height) {
        ctx.lineTo(canvas.width, y);
        ctx.stroke();
        y += squareSize;
        ctx.moveTo(0, y);
    }

}

function getRandomArbitrary(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

function makePlayer() {
    ctx.fillStyle = "#FF0000";
    locationsDict = {"x": [], "y": []};
    var i = 0;
    while(i < 20) {
        var x = getRandomArbitrary(0, canvas.width / squareSize) * squareSize;
        var y = getRandomArbitrary(0, canvas.height / squareSize) * squareSize;
        var lowX = x-squareSize;
        var highX = x+squareSize;
        var lowY = y-squareSize;
        var highY = y+squareSize;
        xPositions = locationsDict["x"];
        yPositions = locationsDict["y"];
        if((xPositions.includes(lowX) || xPositions.includes(highX) || xPositions.includes(x)) && (yPositions.includes(lowY) || yPositions.includes(highY) || yPositions.includes(y))) {}
        else {
            xPositions.push(x);
            yPositions.push(y);
            i += 1
        }

    }
    for(i = 0; i < locationsDict["x"].length; i += 1){
        var xDraw = locationsDict["x"][i];
        var yDraw = locationsDict["y"][i];
        ctx.fillRect(xDraw, yDraw, squareSize, squareSize);
    }
}

