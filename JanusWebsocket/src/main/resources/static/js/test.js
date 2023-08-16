// document.addEventListener("DOMContentLoaded", function() {
function get(name) {
    if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}

let chatId;
const brkrAddr = get('bserver');


function getChatId() {
    if (!chatId) {

        let elementVal = document.getElementById("chatId").value;
        if (elementVal) {
            chatId = +elementVal;
        } else {
            chatId = "123123"
        }
        console.log("chatId =", chatId)
    }

    return chatId;
}

    var socket = new WebSocket("ws://localhost:8080/websocket");
    var chatBox = document.getElementById("chatBox");
    console.log("the chatId is : "+getChatId());

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


function createRoom() {
    sendKafkaMessage({
        id: 'CREATE_STREAM',
        actionId: 1001,
        chatId: getChatId(),
        brokerAddress: brkrAddr/*'192.168.112.66:9093'*/,

    });

    function sendKafkaMessage(message) {
        if (socket.readyState !== socket.OPEN) {
            console.warn("[sendMessage] Skip, WebSocket session isn't open", message.id, message.actionId);
            return;
        }

        const jsonMessage = JSON.stringify(message);
        console.log("[sendMessage] message: " + jsonMessage);
        socket.send(jsonMessage);
    }
}
// });