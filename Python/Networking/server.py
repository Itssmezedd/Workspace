import socket 
import sys 

# Create TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to the port 
server_address = ('localhost',4444)
print("starting up on {} port {}".format(*server_address) )
sock.bind(server_address)

# listen for incoming connection 
sock.listen(1)


while True:
    # wait for a connection 
    print("Waiting for a connection")
    connection, client_address = sock.accept()

    try: 
      while True:
          data = connection.recv(16)
          
          if data:
              print("sending back to the client")
              connection.send(data)
          else:
              print("no data from", client_address)
              break
    finally:
        connection.close() 