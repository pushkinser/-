from subprocess import Popen
import sys

while True:
    print("\nStarting server...")
    p = Popen("python.exe C:/Users/Андрей/OneDrive/хакатоны/pedhack/server/core.py", shell=True)
    p.wait()