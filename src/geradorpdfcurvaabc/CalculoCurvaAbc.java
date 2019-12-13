package systextil.bo.geradorpdfcurvaabc;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AC-85
 */
public class CalculoCurvaAbc {

    public String calculoAbc(float mes, float p_participacao, float p_acumulado, float p_curva_a, float p_curva_b) {
        String v_curva = " ";

        System.out.println("p_parcicao: " + p_participacao);
        System.out.println("p_curva_a: " + p_curva_a);
        System.out.println("p_curva_b: " + p_curva_b);
        System.out.println("p_parcicao: " + (Float )p_participacao);

        float resultadoP = Math.abs(p_participacao - p_acumulado);
        System.out.println("p_parcicao - p_acumulado: " + p_acumulado + " resultado: " + resultadoP);
        if (mes > 0) {
            if ((p_participacao > 0) && ((resultadoP) <= p_curva_a)) {
                v_curva = "A";
            } else if (((resultadoP) > p_curva_a) && ((resultadoP) <= p_curva_b)) {
                v_curva = "B";
            } else {
                v_curva = "C";
            }
        }
        return v_curva;
    }

    public String calculoAbc(int aInt, float aFloat, float aFloat0, float curvaA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
