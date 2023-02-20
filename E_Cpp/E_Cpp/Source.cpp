

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void paridad(int number) {
    if (number % 2) {
        printf("%i is odd\n", number);
        for (int i = number - 2; i > 0; i = i - 2) {
            printf("next odd number is %i\n", i);
        }
    }
    else printf("%i is even\n", number);
    return;

}

struct persona {
    int edad;
    int sexo;

};
void estadisticas(persona* personas) {
    int m_18 = 0; //hombres >18
    int f_18 = 0; //mujeres >18
    int n_m_18 = 0; //hombres <18
    int n_f_18 = 0; //mujeres <18

    for (int i = 0; i < 50; i++) {
        if (personas[i].edad < 18 && personas[i].sexo == 0) n_m_18++;
        else if (personas[i].edad < 18 && personas[i].sexo == 1) n_f_18++;
        else if (personas[i].edad >= 18 && personas[i].sexo == 0) m_18++;
        else f_18++;
    }
    float p_18 = 100 * (m_18 + f_18) / 50;
    float p_f = 100 * (n_f_18 + f_18) / 50;
    printf("Hombres >18: %i\n", m_18);
    printf("Hombres <18: %i\n", n_m_18);
    printf("Mujeres >18: %i\n", f_18);
    printf("Mujeres <18: %i\n", n_f_18);

    printf("Mayores de Edad: %i\n", m_18 + f_18);
    printf("Menores de Edad: %i\n", n_m_18 + n_f_18);
    printf("Porcentaje Mayores de Edad: %f %% \n", p_18);
    printf("Porcentaje Mujeres: %f %%\n", p_f);
}

void leer_persona(persona* personas) {
    for (int i = 0; i < 50; i++) {
        personas[i].edad = rand() % 70;
        personas[i].sexo = rand() % 2;
        printf ("%i - Edad: %i - Genero: %i \n",i+1, personas[i].edad,personas[i].sexo);
    }
}

float leer_tarifa() {
    return (float)(rand() % 40) / 2;
}

int leer_horas() {
    return rand() % 200;
}
void calcular_salario(int horas, float tarifa) {
    float salario = 0;
    if (horas > 40) salario = tarifa * (1.5 * horas - 20); // Reduccion de: tarifa * (40 + 1.5*(horas-40))
    else salario = tarifa * horas;
    printf("Salario Calculado para %i horas con una tarifa de %.1f € = %.2f €\n", horas, tarifa, salario);

}

int main()
{
    srand(time(NULL));
    printf("Prueba Numero Impar\n");
    int numero = 23;
    paridad(numero);
    printf("\n");
    printf("Prueba Numero Par\n");
    numero = 560;
    paridad(numero);
    printf("\n");

    printf("Prueba Clasificacion\n");

    persona personas[50];

    leer_persona(personas);
    printf("\n");
    estadisticas(personas);
    printf("\n");
    printf("Prueba Salario\n");

    float tarifa = leer_tarifa();
    int horas = leer_horas();
    calcular_salario(horas, tarifa);
    return 0;
}

