/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author AC-85
 */
public class FiltrosParametros {
    
    public int agrupamento, qtdeValor, custo, faturamento, nivel;
    public String consideraCancelados;
    public float percPis, percCofins, curvaA, curvaB;
   // public Date termino;

    public FiltrosParametros(int agrupamento, int qtdeValor, int custo, int faturamento, int nivel, String consideraCancelados, float percPis, float percConfins, float curvaA, float curvaB/*, Date termino*/) {
        this.agrupamento = agrupamento;
        this.qtdeValor = qtdeValor;
        this.custo = custo;
        this.faturamento = faturamento;
        this.nivel = nivel;
        this.consideraCancelados = consideraCancelados;
        this.percPis = percPis;
        this.percCofins = percConfins;
        this.curvaA = curvaA;
        this.curvaB = curvaB;
     //   this.termino = termino;
    }

    @Override
    public String toString() {
        return "FiltrosParametros{" + "agrupamento=" + agrupamento + ", qtdeValor=" + qtdeValor + ", custo=" + custo + ", faturamento=" + faturamento + ", nivel=" + nivel + ", consideraCancelados=" + consideraCancelados + ", percPis=" + percPis + ", percCofins=" + percCofins + ", curvaA=" + curvaA + ", curvaB=" + curvaB + '}';
    }

   
    
    
}
