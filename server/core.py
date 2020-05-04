import sys
sys.path.append("C:/Users/Андрей/OneDrive/хакатоны/pedhack/")

import socketserver

import datetime
from server import stat

import json


import warnings

warnings.filterwarnings("ignore")

socketserver.TCPServer.allow_reuse_address = True

class TCPHandler(socketserver.BaseRequestHandler):

    def handle(self):
        
        headers = str('Content-Type: text/plain\nAccess-Control-Allow-Origin: *\nAccess-Control-Allow-Credentials": \"true\"\nAccess-Control-Allow-Methods: \"OPTIONS,POST\"\nAccess-Control-Allow-Headers: \'Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers\"')
        
        
        self.data = str(self.request.recv(512).strip()).split('{')[-1].split('}')[0].split(",")
        print(self.data)
        ids = -1
        if self.data[-1][1:3] == "id":
            ids = int(self.data[-1].split(":")[-1])

        try:
            ans = stat.get_analytic(ids)
            self.request.send(str(
                f"HTTP/1.0 200 OK\n{headers}\n\n" + str(ans)
            ).encode())
        except:
            self.request.send(str(
                f"HTTP/1.0 200 OK\n{headers}\n\n" + "{ERROR}"
            ).encode())


def main():

    HOST, PORT = '192.168.0.14', 5566

    with socketserver.TCPServer((HOST, PORT), TCPHandler) as server:
        server.serve_forever()
        server.data

if __name__ == '__main__':
    main()
    raise Exception("Oh oh, server script died")
