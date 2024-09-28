//Lauren Caballero//

int pin1 = 12;
int pin2 = 8;
int pin3 = 7;
int pin4 = 4;
int pin5 = 2;

void setup()
{
 Serial.begin(9600);
 pinMode(pin1, OUTPUT);
 pinMode(pin2, OUTPUT);
 pinMode(pin3, OUTPUT);
 pinMode(pin4, OUTPUT);
 pinMode(pin5, OUTPUT);
}

float converter(int reader){
  return 5 * reader/1023;
}

void loop()
{
  int inputValue = analogRead(A0);
  int voltage = converter(inputValue);
  
  if (voltage == 0){
    digitalWrite(pin1, LOW);
    digitalWrite(pin2, LOW);
    digitalWrite(pin3, LOW);
    digitalWrite(pin4, LOW);
    digitalWrite(pin5, LOW);
  }else if (voltage == 1){
    digitalWrite(pin1, HIGH);
    digitalWrite(pin2, LOW);
    digitalWrite(pin3, LOW);
    digitalWrite(pin4, LOW);
    digitalWrite(pin5, LOW);
  }else if (voltage == 2){
    digitalWrite(pin1, HIGH);
    digitalWrite(pin2, HIGH);
    digitalWrite(pin3, LOW);
    digitalWrite(pin4, LOW);
    digitalWrite(pin5, LOW);
  }else if (voltage == 3){
    digitalWrite(pin1, HIGH);
    digitalWrite(pin2, HIGH);
    digitalWrite(pin3, HIGH);
    digitalWrite(pin4, LOW);
    digitalWrite(pin5, LOW);
  }else if (voltage == 4){
    digitalWrite(pin1, HIGH);
    digitalWrite(pin2, HIGH);
    digitalWrite(pin3, HIGH);
    digitalWrite(pin4, HIGH);
    digitalWrite(pin5, LOW);
  }else if (voltage == 5){
    digitalWrite(pin1, HIGH);
    digitalWrite(pin2, HIGH);
    digitalWrite(pin3, HIGH);
    digitalWrite(pin4, HIGH);
    digitalWrite(pin5, HIGH);
  }
  
  Serial.println(String(voltage * 10) + " m/s2");
  delay(200);
}

