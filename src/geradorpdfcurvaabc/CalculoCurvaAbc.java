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
        String v_curva = "";

        if (mes > 0) {
            if (p_participacao > 0 && (p_participacao - p_acumulado) < p_curva_a) {
                v_curva = "A";

            } else if (((p_participacao - p_acumulado) > p_curva_a) && ((p_participacao - p_acumulado) < p_curva_b)) {
                v_curva = "B";

            } else {
                v_curva = "C";
            }
        } else {
            v_curva = "";
        }
        return v_curva;
    }

    public String calculoAbc(int aInt, float aFloat, float aFloat0, float curvaA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
