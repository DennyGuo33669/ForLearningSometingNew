import paramiko

HOST = "47.96.151.191"
USER = "guoziwen"
PWD = "njkeypath2021@."
PORT = 22


def connect_linux(HOST, PORT, USER, PWD):
    Client = paramiko.SSHClient()
    try:
        Client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        Client.connect(HOST, PORT, USER, PWD)
    except Exception as e:
        print(e)
    return Client


cmd_linux = connect_linux(HOST, PORT, USER, PWD)
stdin, stdout, stderr = cmd_linux.exec_command(
    "cd /opt/zbox/bin;pwd;./mysql --port=3307 --user=root --password=123456 zentao select id from zt_bug where id>1060;")
print(stdout.read().decode())
