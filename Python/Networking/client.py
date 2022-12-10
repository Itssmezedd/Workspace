import socket
import sys

# Create TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the socket to the port where the server is listening
server_address = ('localhost', 4444)
print("Connecting to {} port {}".format(*server_address))
sock.connect(server_address)

try:
    message = b'Ito yung message'
    #print("sending {!r}".format(message))
    print("sending ", str(message))
    sock.sendall(message)

    # look for the response
    amount_receive = 0
    amount_expected = len(message)

    while amount_receive < amount_expected:
        data = sock.recv(16)
        amount_receive += len(data)
        print("received {!r}".format(data))

finally:
    print("closing socket")
    sock.close()
