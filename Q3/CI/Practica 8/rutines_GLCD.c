#include<p18f4550.h>
#include "GLCD.h"
#include "ascii.h"

// D'us intern
void GLCDBusyWait(byte CS);
byte readByteReal(byte, byte, byte);




#define CS1 PORTBbits.RB0
#define CS2 PORTBbits.RB1
#define RS PORTBbits.RB2
#define RW PORTBbits.RB3
#define E PORTBbits.RB4
#define RST PORTBbits.RB5
#define D0 PORTDbits.RD0
#define D1 PORTDbits.RD1
#define D2 PORTDbits.RD2
#define D3 PORTDbits.RD3
#define D4 PORTDbits.RD4
#define D5 PORTDbits.RD5
#define D6 PORTDbits.RD6
#define D7 PORTDbits.RD7

#define A1 PORTAbits.RA1
#define A2 PORTAbits.RA2
//Codis d'ordres
#define SET_Y_ADDRESS 0x40  //columna
#define SET_START_LINE 0xC0
#define SET_X_ADDRESS 0xB8  //fila
#define SET_ON_OFF 0x3E

// Activacio dels senyals de control del GLCD
#define _CS1 0x1
#define _CS2 0x2
#define _RST 0x20
#define _E 0x10
#define _RW 0x08
#define _RS 0x04



void GLCDBusyWait(byte CS)
{
byte valor;
	TRISD=0xFF;
	TRISB=0;
	//Seleccionem controlador
	if(CS==_CS1)CS1=0;
	if(CS==_CS2)CS2=0;

	RW=1;
	RS=0;
	Nop();
	E=1;
	Nop();
	valor=PORTD;
	E=0;
	while(valor&0x80)
	{
		E=1;	
		Nop();
		valor=PORTD;
		E=0;
	}

	CS1=1;
	CS2=1;
}


// Send command  to GLCD
//
void sendGLCDCommand(byte val, byte CS) 
{
	GLCDBusyWait(CS);

	
	TRISB=0;
	//Seleccionem controlador
	if(CS==_CS1)CS1=0;
	if(CS==_CS2)CS2=0;

	RW=0;
	RS=0;
	Nop();
	E=1;
	Nop();
	PORTD = val;
	TRISD = 0x00;
	Nop();
	E=0;

	CS1=1;
	CS2=1;
}

// Selecciona linea de inici (z= 0 a 63)
// 
void setStartLine(byte z) {
	sendGLCDCommand(SET_START_LINE|z, _CS1);
	sendGLCDCommand(SET_START_LINE|z, _CS2);
}

// Set Page Address  X -row- (x= 0 a 7)
//
void setXAddress(byte page) {
	sendGLCDCommand(SET_X_ADDRESS|page, _CS1);
	sendGLCDCommand(SET_X_ADDRESS|page, _CS2);
}

// Set Y address Y -column- (y= 0 a 127)
//
void setYAddress(byte y) {
	if (y < 64) {								// Part esquerra
		sendGLCDCommand(SET_Y_ADDRESS|y, _CS1); 
		sendGLCDCommand(SET_Y_ADDRESS|0, _CS2);
	}
	else {										// Part dreta
		sendGLCDCommand(SET_Y_ADDRESS|63, _CS1);     
		sendGLCDCommand(SET_Y_ADDRESS|(y-64), _CS2);
	}
}

//Posiciona el cursor
// x [0:7] y [0:127]
void setAddress(byte page, byte y)
{
	setXAddress(page);
	setYAddress(y);
}

// Init GLCD
//
void GLCDinit() {
	RST = 1;
	sendGLCDCommand(SET_ON_OFF|1, _CS1);
	sendGLCDCommand(SET_ON_OFF|1, _CS2);
	setStartLine(0);
}

// Write data on GLCD at position (x,y)(Page x= 0 a 7) (y= 0 a 127)  
//
void writeByte(byte page, byte y, byte data) {
	byte chip = y > 63 ? _CS2 : _CS1;
	setXAddress(page);
	setYAddress(y);

	GLCDBusyWait(chip);

	
	TRISB=0;
	//Seleccionem controlador
	if(chip==_CS1)CS1=0;
	if(chip==_CS2)CS2=0;

	RW=0;
	RS=1;
	Nop();
	E=1;
	Nop();
	PORTD = data;
	TRISD = 0x00;
	Nop();
	E=0;

	CS1=1;
	CS2=1;

}

byte readByteReal(byte page, byte y, byte first) {
	byte data;
	byte chip = y > 63 ? _CS2 : _CS1;
	if(first) {
		setXAddress(page);
		setYAddress(y);
	}

	GLCDBusyWait(chip);

	TRISD = 0xFF;

	TRISB=0;
	//Seleccionem controlador
	if(chip==_CS1)CS1=0;
	if(chip==_CS2)CS2=0;

	RW=1;
	RS=1;
	Nop();
	E=1;
	Nop();
	data = PORTD;
	E=0;

	CS1=1;
	CS2=1;

	return (data);
}

// Read the GLCD RAM at position (x,y) (x= 0 a 7) (y= 0 a 127)  
//
// Two acces are required to read data
// 1st is a dummy access. 2nd is RAM value
byte readByte(byte page, byte y)
 {
	byte aux;
	readByteReal(page, y, 1);
	aux=readByteReal(page,y, 1);
	return(aux);
}

//  Clear all pixels in ri to re rows and ci to ce columns 
// ri,re [0:7] ci,ce [0:127]
void clearGLCD(byte ri, byte re, byte ci, byte ce) 
{
int i,j;

	for (i = ri; i <= re; i++) 
		for (j=ci;j<=ce;j++)
			writeByte(i,j,0);
}

// NO IMPLEMENTADES
//
// x [0:63] y [0:127]
void SetDot(byte x, byte y) {
	
	int i, j, k, l;
	byte q;
	i = x;
	i = x / 8;
	k = x % 8;
	l = 1;
	while (k > 0){
		l *= 2 ;
		--k;
	}
	j = y;
	
	q = readByte(i, j);
	l= l|q;
	writeByte(i,j,l);



}
// x [0:63] y [0:127]
void ClearDot(byte x, byte y) {
	int i, j, k, l;
	byte q;
	i = x;
	i = x / 8;
	k = x % 8;
	l = 1;
	while (k > 0){
		l *= 2 ;
		--k;
	}
	
	j = y;
	q = readByte(i, j);
	l = 0xFF - l;
	l = l & q;
	writeByte(i,j,l);
}

// Escriu el caracter c en la posicio (x,y) (x= 0 a 7) (y= 0 a 20)
// Els caracters estan definits en la taula font5x7[] 
void putch(byte page, byte y, char c) {
	int i;
	int k, j;
	byte p;
	k = c - 32;
	k *= 5;
	for(i = 0; i < 5; i++){
		writeByte(page, y+i, font5x7[k]);
		k++;
	}	
}




#define D0 PORTDbits.RD0
#define D1 PORTDbits.RD1
#define D2 PORTDbits.RD2
#define D3 PORTDbits.RD3

void ConfigKeyPad(void) {
	TRISD = 0x0F;
}

char ScanKeyPad(void) {
	byte b = 0x10;
	ConfigKeyPad();
	while(1) {
		int i;
		PORTD = b;
		if (D0 || D1 || D2|| D3) { /*si polsem algo que vagi a mirar que es*/
			int fila = 0;
			byte m = 1;
			b = b >> 4;
			while (b != m) {
				m = m << 1;
				++fila;
			}
			if (fila == 0) {
				if (D0 == 1) return '1';
				if (D1 == 1) return '2';
				if (D2 == 1) return '3';
				if (D3 == 1) return 'A';
			}
			if (fila == 1) {
				if (D0 == 1) return '4';
				if (D1 == 1) return '5';
				if (D2 == 1) return '6';
				if (D3 == 1) return 'B';
			}
			if (fila == 2) {
				if (D0 == 1) return '7';
				if (D1 == 1) return '8';
				if (D2 == 1) return '9';
				if (D3 == 1) return 'C';
			}
			if (fila == 3) {
				if (D0 == 1) return '*';
				if (D1 == 1) return '0';
				if (D2 == 1) return '#';
				if (D3 == 1) return 'D';
			}
		}
		b = b << 1;
	if (b == 0) b = 0x10; /* va rotant la mascara*/
	}	
}

void PintaPulsacions(char c) {
	while (D0 || D1 || D2|| D3); 
	TRISD = 0x00;
	putch(4, 4, c);
}

void PintaPulsacions2(char c, int x, int y) {
	while (D0 || D1 || D2|| D3); 
	TRISD = 0x00;
	putch(x, y, c);
}


char int_to_char(int n) {
	return ('0' + n);
}

void ini_pant(void) {
	putch(2, 0, 'C');
	putch(2, 6, 'O');
	putch(2, 12, 'N');
	putch(2, 18, 'T');
	putch(2, 24, ' ');
	putch(2, 30, '0');//h
	putch(2, 36, '0');//h
	putch(2, 42, ':');
	putch(2, 48, '0');//m
	putch(2, 54, '0');//m
	putch(2, 60, ':');
	putch(2, 66, '0');
	putch(2, 72, '0');
	
}

void write_time(int n) {
	putch(2, 72, int_to_char(n%10));//s
	n /= 10;
	putch(2, 66, int_to_char(n%6));	//s
	n /= 6;
	putch(2, 54, int_to_char(n%10));//m
	n /= 10;
	putch(2, 48, int_to_char(n%6)); //m
	n /= 6;
	putch(2, 36, int_to_char(n%10));//h
	n /= 10;
	putch(2, 30, int_to_char(n%3)); //h
}


void write_time2(int n) {
	putch(2, 72, int_to_char(n%10));//cs
	n /= 10;
	putch(2, 66, int_to_char(n%10));	//cs
	n /= 10;
	putch(2, 54, int_to_char(n%10));//s
	n /= 10;
	putch(2, 48, int_to_char(n%6)); //s
	n /= 6;
	putch(2, 36, int_to_char(n%10));//m
	n /= 10;
	putch(2, 30, int_to_char(n%3)); //m
}



