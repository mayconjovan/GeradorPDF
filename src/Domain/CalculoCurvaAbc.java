/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author AC-85
 */
public class CalculoCurvaAbc {

    public String calculoAbc(float p_participacao, float p_acumulado, float p_curva_a, float p_curva_b) {
        String v_curva = "";

        if (p_participacao > 0 && (p_participacao - p_acumulado) <= p_curva_a) {
            v_curva = "A";

        } else if (((p_participacao - p_acumulado) > p_curva_a) && ((p_participacao - p_acumulado) <= p_curva_b)) {
            v_curva = "B";

        } else {
            v_curva = "C";
        }
        return v_curva;
    }
}
