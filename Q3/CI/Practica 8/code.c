#include <p18f4550.h>
#include "config.h"
#include "GLCD.h"

void high_ISR(void);
int temps;
char volatile TMR0_int = 0;

void ini_timer(void) {
	TMR0H = 0x00;
	TMR0L = 0x00;
}

void main(void)
{
	unsigned char x;
	unsigned char y;
	char t;
	int time;
	TRISD = 0;
	PORTD = 0;
	TRISB = 0x00;
	TRISA = 0xFF;
	PORTB = 0;
	T0CON = 0x88;
	GLCDinit();
	clearGLCD(0,7,0,127);
	ADCON1 = 0x0D;
	ADCON0 = 0x05;
	ADCON2 = 0x11;
	y = 20;
	t = 0;
	while(1)
	{
		ADCON0bits.GO = 1;
		while (ADCON0bits.GO) { }
		x = ADRESH;
		x = x/8 + 24;
		SetDot(x, y);
		y++;
		if (y == 100) {
			y = 20;
			clearGLCD(0,7,0,127);
		}
	}
}