# Laboratorio Drools 

### Laboratorio #2 de Fundamentos de Sistemas de Información sobre reglas de negocio usando Springboot y Drools

:busts_in_silhouette: Juan Sebastián Naranjo Jiménez, Paulina García Aristizábal, Juan Pablo Castro Hoyos

###

**Introducción:** En este laboratorio se utilizó el framework Drools, el cual es un motor de reglas Java que se encarga de aplicar reglas de negocio dentro de las aplicaciones. 

:money_with_wings: En este caso la aplicación fue sobre las reglas de negocio de un banco para otorgar créditos.

**Desarrollo:** Se siguieron los pasos de la [guía de laboratorio]([https://docs.google.com/document/d/1d10WJ7EWBvuSx1z00uwjQsLc72wKuRwCcG95FxDikXI/edit?usp=sharing]"Guía") y adicional a eso se crearon 10 reglas de negocio nuevas. Para esto es fundamental tener en cuenta los atributos que tiene el modelo "Participant", para algunas reglas se crearon nuevos atributos y para otras se usaron algunos ya existentes.

Entre los nuevos atributos creados están:

-private boolean haveJob;

-private boolean haveJudicialBackground;

-private int quantityDependants;

-private int yearsInCurrentJob;

**Estructura de las reglas de negocio con Drools:**

-Con **rule** se define el nombre de la regla. 

-Con la palabra reservada **when** se indica la condición de aplicación de la regla, es decir que aquí se ponen las condiciones que deben cumplir los objetos para aplicar la regla.

-Con la coma se separan condiciones, que se evalúan como un Y lógico (conjunción). Aquí también se pueden poner disyunciones (O lógico) y negaciones.

-En la sección del **then** especificamos las acciones que ejecutará la regla cuando se cumplan sus condiciones.

-Con la palabra **end** se finaliza.

**Nuevas reglas de negocio:**

-**"Checking Age for Credit Apply"** Verifica que la edad del participante no sea menor de 18 años o mayor de 65 años.

-**"Checking if Participant have job"** Verifica si el participante tiene trabajo, si no tiene trabajo se rechaza.

-**"Checking if Participant have judicial backgorund"** Verifica si el participante tiene antecedentes judiciales, si este es el caso se rechaza.

-**"Checking if Participant dependants"** Verifica cuántas personas a cargo tiene el participante, si tiene más de 3 personas a cargo se rechaza.

-**"Check Loan Eligibility"** Aprueba un préstamos si el cliente tiene un puntaje de crédito superior a 700 y si su salario es más del doble de la cantidad solicitada del préstamo.

-**"Recommend Preferred Savings Account"** Ofrece una cuenta de ahorro con intereses altos y sin comisiones si el salario del cliente es mayor a 80000 y su deuda existente es menor a 20000.

-**"Offer Line of Credit"** Recomendará una línea de crédito al cliente con una tasa de interés de 5.5% si tiene una deuda existente menor a 10000 y si su salario está entre 50000 y 80000.

-**"Recommend Credit Card"** Le sugiere al aplicante una tarjeta de crédito luego de evaluar que cumple con un score crediticio mayor a 650 puntos, con un salario anual mínimo de 40001 USD, y sin contar con antecedentes judiciales. Esta tarjeta tiene bajos intereses anuales y le permite al cliente participar de programas de recompensas y de cashback.

-**"Applicant with job stability"** Verifica la cantidad, en años, del trabajo actual del aplicante. Si el trabajador cuenta con una estabilidad laboral en su organización de 3 años en adelante, se le aplica un descuento del 5% en el valor de la tasa.

-**"Check existing debt to Annual Salary Ratio"** Valida si la deuda existente actual del aplicante supera la mitad de su salario anual devengado. Si es así, demuestra desbordamiento de su capacidad de endeudamiento y representa riesgo inmediato para el banco, negando el estado de aprobación del crédito.

Finalmente, se ejecuta la aplicación y luego se prueba en Postman de la siguiente manera:

1. Colocar la siguiente URL de tipo POST: http://localhost:8080/bankservice/getrate

2. Escribir el JSON con la siguiente estructura e ir cambiando los valores de acuerdo a lo que se quiera probar

  {

    "name": "Test User",

    "age": 25,

    "creditScore": 550,

    "annualSalary": 10000000,

    "existingDebt": 1000,

    "loanAmount": "400",

    "haveJob": true,

    "haveJudicialBackground": false,

    "quantityDependants": 4,

    "yearsInCurrentJob": 3

  }

