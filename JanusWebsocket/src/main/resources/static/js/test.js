var chatId =  Math.floor((Math.random() * 100) + 1);
document.addEventListener("DOMContentLoaded", function() {
    var socket = new WebSocket("ws://localhost:8080/websocket");
    var chatBox = document.getElementById("chatBox");
    console.log("the chatId is : "+chatId);

    // Connection opened
    socket.onopen = function(event) {
        console.log("WebSocket connection opened");

        // Send a message to the server
        socket.send("Hello, Server!");
    };

    // Listen for messages from the server
    socket.onmessage = function(event) {
        var message = event.data;
        console.log("Received message from server: " + message);

        // Add the received message to the chat box
        var messageElement = document.createElement("p");
        messageElement.textContent = "Received message: " + message;
        chatBox.appendChild(messageElement);
    };

    // Connection closed
    socket.onclose = function(event) {
        console.log("WebSocket connection closed");
    };

    // Handle form submission
    var form = document.getElementById("chatForm");
    var input = document.getElementById("chatInput");

    form.addEventListener("submit", function(event) {
        event.preventDefault();

        var message = input.value;

        // Send the message to the server
        socket.send(message);

        // Add the sent message to the chat box
        var messageElement = document.createElement("p");
        messageElement.textContent = "Sent message: " + message;
        chatBox.appendChild(messageElement);

        // Clear the input field
        input.value = "";
    });
});