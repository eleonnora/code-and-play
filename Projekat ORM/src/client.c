#include<stdio.h>      //printf
#include<string.h>     //strlen
#include<sys/socket.h> //socket
#include<arpa/inet.h>  //inet_addr
#include <fcntl.h>     //for open
#include <unistd.h>    //for close

#define DEFAULT_BUFLEN 512
#define DEFAULT_PORT 27015

char username[32],password[15];
char chek[2];
int sock;
char actionForServer[2];

void PrintMenu();
void ChekMailBox();
void SendMessage();
void ReceiveMessage();
void LogIn();
void LogOut();

int main(int argc , char *argv[])
{
    
    struct sockaddr_in server;
    
    sock = socket(AF_INET , SOCK_STREAM , 0);

    server.sin_addr.s_addr = inet_addr("127.0.0.1");
    server.sin_family = AF_INET;
    server.sin_port = htons(DEFAULT_PORT);

    //connect(sock , (struct sockaddr *)&server , sizeof(server));
    if (connect(sock , (struct sockaddr *)&server , sizeof(server)) < 0){
        perror("Connect failed. Error");
        return 1;
    }

    LogIn();
    while(1)
    {
	
	int option;
	printf("\n Available options: \n");
	printf("1. Chek mailbox \n");
	printf("2. Send message \n");
	printf("3. Logout \n");
	printf("4. Receive message \n");
	printf("5. Close \n");
	printf("\n Enter a number for selected action: ");
	scanf(" %d", &option);
	switch (option){
		case 1: 
			ChekMailBox();
			break;
		case 2: 
			SendMessage();			
			break;
		case 3: 
			LogOut();
			break;
		case 4:
			ReceiveMessage();
	}
	if(option == 5)
		break;		
	
	
    }
    close(sock);

    return 0;
}

void ReceiveMessage()
{
	char message[DEFAULT_BUFLEN];
	actionForServer[0] = '4';
	send(sock, actionForServer, 2, 0);
	recv(sock, message, 256, 0);
	printf("\n Message: \n\n %s \n", message);
}

void ChekMailBox()
{
	actionForServer[0] = '1';
	send(sock, actionForServer, 2, 0);
	char numOfMsg[2];
	recv(sock, numOfMsg, 2, 0);
	printf("\n Number of messages: %s\n ", numOfMsg);
}

void SendMessage()
{
	char receiver[15], message[256], chekUser[2];
	actionForServer[0] = '2';
	send(sock, actionForServer, 2, 0);
	printf("\n Send message to (username): ");
	scanf(" %s",receiver);
	send(sock, receiver, 15, 0);
	recv(sock, chekUser, 2, 0);
	if(chekUser[0] == '1')
	{
		printf("\n Message: \n");
		scanf(" %s",message);
		if(send(sock, message, 256, 0) < 0)
			printf("Sending failed.");
		else
			printf("\n Message sent to %s .\n", receiver);
		
	}
	else if(chekUser[0] == '0')
	{
		printf("\n User %s does not exist!", receiver);
		
	}
	
}

void LogOut()
{
	printf("\n You are logged out.\n\n");
	actionForServer[0] = '3';
	send(sock, actionForServer, 2, 0);
	LogIn();

}

void LogIn()
{
	int j;
	begin:
	for(j = 0; j < 15; j++)
		username[j] = '\0';

	for(j = 0; j < 15; j++)
		password[j] = '\0';
	
    	printf("Username: ");
	gets(username);
    	printf("Password: ");
	gets(password);
    	
    	send(sock, username, 15, 0);
	send(sock, password, 15, 0);

	recv(sock, chek, 2, 0);
	if(chek[0] == '0'){
		printf("\n Wrong username/password! Try again. \n");
		goto begin;
    	}else if(chek[0] == '1'){
		printf("\n You are logged in as  %s  \n", username);
    	}
}

