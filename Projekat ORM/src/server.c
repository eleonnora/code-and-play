#include<stdio.h>
#include<string.h>    //strlen
#include<sys/socket.h>
#include<arpa/inet.h> //inet_addr
#include<unistd.h>    //write

#define DEFAULT_BUFLEN 512
#define DEFAULT_PORT   27015
#define LENGTH_OF_CLIENT 30
#define LENGTH_OF_BASE 3

struct Members {
	char username[15];
	char password[15];
	char message[256];
	int numOfMsg;
};

int indexOfClient;

int SearchClient(struct Members member[], char user[], char pass[])
{
    int result, i;
    for(i = 0; i < LENGTH_OF_BASE; i++)
    {
	result = strcmp(member[i].username, user);
	if(result == 0){
	     result = strcmp(member[i].password, pass);
	     if(result == 0){
		indexOfClient = i;
		return 1;
	     }
        }	
    }
    
    return 0;
}

int ChekUser(struct Members member[], char user[])
{
	int i, result;
	for(i = 0; i < LENGTH_OF_BASE; i++)
	{ 
		result = strcmp(member[i].username, user);
		if(result == 0)
			return i;
	}
	return -1;
}

int main(int argc , char *argv[])
{
    int socketDesc , clientSock , c;
    struct sockaddr_in server , client;
    char username[15];
    char password[15];

    struct Members member[3];
    strcpy(member[0].username, "Eleonora");
    strcpy(member[0].password, "02071994");
    strcpy(member[0].message, "Poruka na pocetku za ELuu");
    member[0].numOfMsg = 1;
    strcpy(member[1].username, "Una");
    strcpy(member[1].password, "13051994");
    strcpy(member[1].message, "Poruka na pocetku za Unuuu");
    member[1].numOfMsg = 1;

    strcpy(member[2].username, "mare");
    strcpy(member[2].password, "car");
    strcpy(member[2].message, "Poruka na pocetku za mareta");
    member[1].numOfMsg = 1;
   
    socketDesc = socket(AF_INET , SOCK_STREAM , 0);
    if (socketDesc == -1)
        printf("Could not create socket");
    
    server.sin_family = AF_INET;
    server.sin_addr.s_addr = INADDR_ANY;
    server.sin_port = htons(DEFAULT_PORT);

    if( bind(socketDesc,(struct sockaddr *)&server , sizeof(server)) < 0)
    {
        perror("bind failed. Error");
        return 1;
    }

    listen(socketDesc , 1);

    puts("Waiting for incoming connections...");
    c = sizeof(struct sockaddr_in);

    clientSock = accept(socketDesc, (struct sockaddr *)&client, (socklen_t*)&c);
	if (clientSock < 0)
    {
        perror("accept failed");
        return 1;
    }
 
  
    while(1)
    {
         int j, chek, user;
	 char isCorrect[2], option[2];
	 char receiver[15], chekUser[2];
	 isCorrect[0] = '\0';

	 for(j = 0; j < 15; j++){
		username[j] = '\0';
		password[j] = '\0';
	 }

	 begin:
	 recv(clientSock, username, 15, 0);
	 recv(clientSock, password, 15, 0);
	 chek = SearchClient(member, username, password);

         if(chek == 0){
		isCorrect[0] = '0';
		send(clientSock, isCorrect, 2, 0);
		goto begin;
	 }
       	 else if(chek == 1){
		isCorrect[0] = '1';
		send(clientSock, isCorrect, 2, 0);
	 }
	 	 
	 options:
	 recv(clientSock, option, 2, 0);
	 switch(option[0])
	 {

		case '1':
			option[0] = member[indexOfClient].numOfMsg+48;
			send(clientSock, option, 2, 0);
			goto options;
			break;
			
		case '2':
			recv(clientSock,receiver,15,0);
			user = ChekUser(member, receiver);
			if(user == -1){
				chekUser[0] = '0';
				send(clientSock, chekUser, 2, 0);
			}else{
				chekUser[0] = '1';
				send(clientSock, chekUser, 2, 0);
				recv(clientSock, member[user].message, 256, 0);
				if(member[user].numOfMsg < 1)
					member[user].numOfMsg++;
			}
			goto options;	
			
		case '3':
			goto begin;
		
		case '4':
			send(clientSock, member[indexOfClient].message, 256, 0);
			if(member[indexOfClient].numOfMsg > 0)			
				member[indexOfClient].numOfMsg--;	
			strcpy(member[indexOfClient].message, "");
			goto options;
	}
         
    }

    
    

    return 0;
}


