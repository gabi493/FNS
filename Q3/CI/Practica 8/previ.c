#include <p18f4550.h>
#include "config.h"
#include "GLCD.h"

char conversion = 1;
int aux;

void hISR(void);

#pragma code high_vector = 0x08
void goISR(void) { _asm goto hISR _endasm }
#pragma code

#pragma interrupt hISR
void hISR(void)
{
	if (PIR1bits.ADIF)
	{
		PORTB = ADRESH;

		PIR1bits.ADIF = 0;
		conversion = 1;
}	}

void main(void)
{
	TRISB = 0;
	RCONbits.IPEN = 1;
	INTCONbits.GIE = 1;	// habilitamos interr.
	PIE1bits.ADIE = 1;	// habilitamos interr. del canvertidor AD
	IPR1bits.ADIP = 1;
	ADCON0 = 0b00000101; // channel 1(AN1); AD converter module is On
	ADCON1 = 0b00001101;// RA0 & RA1 analog; others digital;
	ADCON2 = 0b00010001; // left justified; 4Tad; Fosc/8;
	while(1)
	{
		if (conversion)
		{
			ADCON0bits.GO = 1;
			conversion = 0;
			
		}
	}
}