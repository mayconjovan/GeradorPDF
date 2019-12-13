package systextil.bo.geradorpdfcurvaabc;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorView {

    public String AGRUPAMENTO_1, AGRUPAMENTO_2, DESCRICAO_AGRUPAMENTO1, DESCRICAO_AGRUPAMENTO2,
            CURVAMES01,
            CURVAMES02,
            CURVAMES03,
            CURVAMES04,
            CURVAMES05,
            CURVAMES06,
            CURVAMES07,
            CURVAMES08,
            CURVAMES09,
            CURVAMES10,
            CURVAMES11,
            CURVAMES12,
            CURVAMES13,
            CURVAGERAL;

    public int MES01, MES02, MES03, MES04, MES05, MES06,
            MES07, MES08, MES09, MES10, MES11, MES12, MES13, margem, faturamentoLiquido;

    public float PART_GR1, ACU_GR1, CMV,
            CMV_GERAL, CMV_PARTICIPACAO_GERAL, ACUM_CMV_PARTICIPACAO_GERAL,
            VENDIDO, VENDIDO_GR1, VENDIDO_GERAL, PARTICIPACAO_GERAL,
            ACUM_PARTICIPACAO_GERAL, MEDIA, GR1_MES01, GR1_MES02,
            GR1_MES03, GR1_MES04, GR1_MES05, GR1_MES06, GR1_MES07, GR1_MES08,
            GR1_MES09, GR1_MES10, GR1_MES11, GR1_MES12, GR1_MES13, PART_GR1_MES01,
            PART_GR1_MES02, PART_GR1_MES03, PART_GR1_MES04, PART_GR1_MES05, PART_GR1_MES06,
            PART_GR1_MES07, PART_GR1_MES08, PART_GR1_MES09, PART_GR1_MES10,
            PART_GR1_MES11, PART_GR1_MES12, PART_GR1_MES13, ACU_GR1_MES01,
            ACU_GR1_MES02, ACU_GR1_MES03, ACU_GR1_MES04, ACU_GR1_MES05,
            ACU_GR1_MES06, ACU_GR1_MES07, ACU_GR1_MES08, ACU_GR1_MES09,
            ACU_GR1_MES10, ACU_GR1_MES11, ACU_GR1_MES12, ACU_GR1_MES13,
            GERAL_MES01, GERAL_MES02, GERAL_MES03, GERAL_MES04, GERAL_MES05,
            GERAL_MES06, GERAL_MES07, GERAL_MES08, GERAL_MES09, GERAL_MES10,
            GERAL_MES11, GERAL_MES12, GERAL_MES13, PARTICIPACAO_GERAL_MES01,
            PARTICIPACAO_GERAL_MES02, PARTICIPACAO_GERAL_MES03,
            PARTICIPACAO_GERAL_MES04, PARTICIPACAO_GERAL_MES05,
            PARTICIPACAO_GERAL_MES06, PARTICIPACAO_GERAL_MES07,
            PARTICIPACAO_GERAL_MES08, PARTICIPACAO_GERAL_MES09,
            PARTICIPACAO_GERAL_MES10, PARTICIPACAO_GERAL_MES11,
            PARTICIPACAO_GERAL_MES12, PARTICIPACAO_GERAL_MES13,
            ACUM_GR1_MES01, ACUM_GR1_MES02, ACUM_GR1_MES03, ACUM_GR1_MES04,
            ACUM_GR1_MES05, ACUM_GR1_MES06, ACUM_GR1_MES07, ACUM_GR1_MES08,
            ACUM_GR1_MES09, ACUM_GR1_MES10, ACUM_GR1_MES11, ACUM_GR1_MES12,
            ACUM_GR1_MES13;

    public ConstrutorView() {
    }

    public int getFaturamentoLiquido() {
        return faturamentoLiquido;
    }

    public void setFaturamentoLiquido(int faturamentoLiquido) {
        this.faturamentoLiquido = faturamentoLiquido;
    }

    public int getMargem() {
        return margem;
    }

    public void setMargem(int margem) {
        this.margem = margem;
    }

    public String getAGRUPAMENTO_1() {
        return AGRUPAMENTO_1;
    }

    public void setAGRUPAMENTO_1(String AGRUPAMENTO_1) {
        this.AGRUPAMENTO_1 = AGRUPAMENTO_1;
    }

    public String getAGRUPAMENTO_2() {
        return AGRUPAMENTO_2;
    }

    public void setAGRUPAMENTO_2(String AGRUPAMENTO_2) {
        this.AGRUPAMENTO_2 = AGRUPAMENTO_2;
    }

    public String getDESCRICAO_AGRUPAMENTO1() {
        return DESCRICAO_AGRUPAMENTO1;
    }

    public void setDESCRICAO_AGRUPAMENTO1(String DESCRICAO_AGRUPAMENTO1) {
        this.DESCRICAO_AGRUPAMENTO1 = DESCRICAO_AGRUPAMENTO1;
    }

    public String getDESCRICAO_AGRUPAMENTO2() {
        return DESCRICAO_AGRUPAMENTO2;
    }

    public void setDESCRICAO_AGRUPAMENTO2(String DESCRICAO_AGRUPAMENTO2) {
        this.DESCRICAO_AGRUPAMENTO2 = DESCRICAO_AGRUPAMENTO2;
    }

    public String getCURVAMES01() {
        return CURVAMES01;
    }

    public void setCURVAMES01(String CURVAMES01) {
        this.CURVAMES01 = CURVAMES01;
    }

    public String getCURVAMES02() {
        return CURVAMES02;
    }

    public void setCURVAMES02(String CURVAMES02) {
        this.CURVAMES02 = CURVAMES02;
    }

    public String getCURVAMES03() {
        return CURVAMES03;
    }

    public void setCURVAMES03(String CURVAMES03) {
        this.CURVAMES03 = CURVAMES03;
    }

    public String getCURVAMES04() {
        return CURVAMES04;
    }

    public void setCURVAMES04(String CURVAMES04) {
        this.CURVAMES04 = CURVAMES04;
    }

    public String getCURVAMES05() {
        return CURVAMES05;
    }

    public void setCURVAMES05(String CURVAMES05) {
        this.CURVAMES05 = CURVAMES05;
    }

    public String getCURVAMES06() {
        return CURVAMES06;
    }

    public void setCURVAMES06(String CURVAMES06) {
        this.CURVAMES06 = CURVAMES06;
    }

    public String getCURVAMES07() {
        return CURVAMES07;
    }

    public void setCURVAMES07(String CURVAMES07) {
        this.CURVAMES07 = CURVAMES07;
    }

    public String getCURVAMES08() {
        return CURVAMES08;
    }

    public void setCURVAMES08(String CURVAMES08) {
        this.CURVAMES08 = CURVAMES08;
    }

    public String getCURVAMES09() {
        return CURVAMES09;
    }

    public void setCURVAMES09(String CURVAMES09) {
        this.CURVAMES09 = CURVAMES09;
    }

    public String getCURVAMES10() {
        return CURVAMES10;
    }

    public void setCURVAMES10(String CURVAMES10) {
        this.CURVAMES10 = CURVAMES10;
    }

    public String getCURVAMES11() {
        return CURVAMES11;
    }

    public void setCURVAMES11(String CURVAMES11) {
        this.CURVAMES11 = CURVAMES11;
    }

    public String getCURVAMES12() {
        return CURVAMES12;
    }

    public void setCURVAMES12(String CURVAMES12) {
        this.CURVAMES12 = CURVAMES12;
    }

    public String getCURVAMES13() {
        return CURVAMES13;
    }

    public void setCURVAMES13(String CURVAMES13) {
        this.CURVAMES13 = CURVAMES13;
    }

    public String getCURVAGERAL() {
        return CURVAGERAL;
    }

    public void setCURVAGERAL(String CURVAGERAL) {
        this.CURVAGERAL = CURVAGERAL;
    }

    public float getPART_GR1() {
        return PART_GR1;
    }

    public void setPART_GR1(float PART_GR1) {
        this.PART_GR1 = PART_GR1;
    }

    public float getACU_GR1() {
        return ACU_GR1;
    }

    public void setACU_GR1(float ACU_GR1) {
        this.ACU_GR1 = ACU_GR1;
    }

    public float getCMV() {
        return CMV;
    }

    public void setCMV(float CMV) {
        this.CMV = CMV;
    }

    public float getCMV_GERAL() {
        return CMV_GERAL;
    }

    public void setCMV_GERAL(float CMV_GERAL) {
        this.CMV_GERAL = CMV_GERAL;
    }

    public float getCMV_PARTICIPACAO_GERAL() {
        return CMV_PARTICIPACAO_GERAL;
    }

    public void setCMV_PARTICIPACAO_GERAL(float CMV_PARTICIPACAO_GERAL) {
        this.CMV_PARTICIPACAO_GERAL = CMV_PARTICIPACAO_GERAL;
    }

    public float getACUM_CMV_PARTICIPACAO_GERAL() {
        return ACUM_CMV_PARTICIPACAO_GERAL;
    }

    public void setACUM_CMV_PARTICIPACAO_GERAL(float ACUM_CMV_PARTICIPACAO_GERAL) {
        this.ACUM_CMV_PARTICIPACAO_GERAL = ACUM_CMV_PARTICIPACAO_GERAL;
    }

    public float getVENDIDO() {
        return VENDIDO;
    }

    public void setVENDIDO(float VENDIDO) {
        this.VENDIDO = VENDIDO;
    }

    public float getVENDIDO_GR1() {
        return VENDIDO_GR1;
    }

    public void setVENDIDO_GR1(float VENDIDO_GR1) {
        this.VENDIDO_GR1 = VENDIDO_GR1;
    }

    public float getVENDIDO_GERAL() {
        return VENDIDO_GERAL;
    }

    public void setVENDIDO_GERAL(float VENDIDO_GERAL) {
        this.VENDIDO_GERAL = VENDIDO_GERAL;
    }

    public float getPARTICIPACAO_GERAL() {
        return PARTICIPACAO_GERAL;
    }

    public void setPARTICIPACAO_GERAL(float PARTICIPACAO_GERAL) {
        this.PARTICIPACAO_GERAL = PARTICIPACAO_GERAL;
    }

    public float getACUM_PARTICIPACAO_GERAL() {
        return ACUM_PARTICIPACAO_GERAL;
    }

    public void setACUM_PARTICIPACAO_GERAL(float ACUM_PARTICIPACAO_GERAL) {
        this.ACUM_PARTICIPACAO_GERAL = ACUM_PARTICIPACAO_GERAL;
    }

    public float getMEDIA() {
        return MEDIA;
    }

    public void setMEDIA(float MEDIA) {
        this.MEDIA = MEDIA;
    }

    public int getMES01() {
        return MES01;
    }

    public void setMES01(int MES01) {
        this.MES01 = MES01;
    }

    public int getMES02() {
        return MES02;
    }

    public void setMES02(int MES02) {
        this.MES02 = MES02;
    }

    public int getMES03() {
        return MES03;
    }

    public void setMES03(int MES03) {
        this.MES03 = MES03;
    }

    public int getMES04() {
        return MES04;
    }

    public void setMES04(int MES04) {
        this.MES04 = MES04;
    }

    public int getMES05() {
        return MES05;
    }

    public void setMES05(int MES05) {
        this.MES05 = MES05;
    }

    public int getMES06() {
        return MES06;
    }

    public void setMES06(int MES06) {
        this.MES06 = MES06;
    }

    public int getMES07() {
        return MES07;
    }

    public void setMES07(int MES07) {
        this.MES07 = MES07;
    }

    public int getMES08() {
        return MES08;
    }

    public void setMES08(int MES08) {
        this.MES08 = MES08;
    }

    public int getMES09() {
        return MES09;
    }

    public void setMES09(int MES09) {
        this.MES09 = MES09;
    }

    public int getMES10() {
        return MES10;
    }

    public void setMES10(int MES10) {
        this.MES10 = MES10;
    }

    public int getMES11() {
        return MES11;
    }

    public void setMES11(int MES11) {
        this.MES11 = MES11;
    }

    public int getMES12() {
        return MES12;
    }

    public void setMES12(int MES12) {
        this.MES12 = MES12;
    }

    public int getMES13() {
        return MES13;
    }

    public void setMES13(int MES13) {
        this.MES13 = MES13;
    }
    
    
   
    public float getGR1_MES01() {
        return GR1_MES01;
    }

    public void setGR1_MES01(float GR1_MES01) {
        this.GR1_MES01 = GR1_MES01;
    }

    public float getGR1_MES02() {
        return GR1_MES02;
    }

    public void setGR1_MES02(float GR1_MES02) {
        this.GR1_MES02 = GR1_MES02;
    }

    public float getGR1_MES03() {
        return GR1_MES03;
    }

    public void setGR1_MES03(float GR1_MES03) {
        this.GR1_MES03 = GR1_MES03;
    }

    public float getGR1_MES04() {
        return GR1_MES04;
    }

    public void setGR1_MES04(float GR1_MES04) {
        this.GR1_MES04 = GR1_MES04;
    }

    public float getGR1_MES05() {
        return GR1_MES05;
    }

    public void setGR1_MES05(float GR1_MES05) {
        this.GR1_MES05 = GR1_MES05;
    }

    public float getGR1_MES06() {
        return GR1_MES06;
    }

    public void setGR1_MES06(float GR1_MES06) {
        this.GR1_MES06 = GR1_MES06;
    }

    public float getGR1_MES07() {
        return GR1_MES07;
    }

    public void setGR1_MES07(float GR1_MES07) {
        this.GR1_MES07 = GR1_MES07;
    }

    public float getGR1_MES08() {
        return GR1_MES08;
    }

    public void setGR1_MES08(float GR1_MES08) {
        this.GR1_MES08 = GR1_MES08;
    }

    public float getGR1_MES09() {
        return GR1_MES09;
    }

    public void setGR1_MES09(float GR1_MES09) {
        this.GR1_MES09 = GR1_MES09;
    }

    public float getGR1_MES10() {
        return GR1_MES10;
    }

    public void setGR1_MES10(float GR1_MES10) {
        this.GR1_MES10 = GR1_MES10;
    }

    public float getGR1_MES11() {
        return GR1_MES11;
    }

    public void setGR1_MES11(float GR1_MES11) {
        this.GR1_MES11 = GR1_MES11;
    }

    public float getGR1_MES12() {
        return GR1_MES12;
    }

    public void setGR1_MES12(float GR1_MES12) {
        this.GR1_MES12 = GR1_MES12;
    }

    public float getGR1_MES13() {
        return GR1_MES13;
    }

    public void setGR1_MES13(float GR1_MES13) {
        this.GR1_MES13 = GR1_MES13;
    }

    public float getPART_GR1_MES01() {
        return PART_GR1_MES01;
    }

    public void setPART_GR1_MES01(float PART_GR1_MES01) {
        this.PART_GR1_MES01 = PART_GR1_MES01;
    }

    public float getPART_GR1_MES02() {
        return PART_GR1_MES02;
    }

    public void setPART_GR1_MES02(float PART_GR1_MES02) {
        this.PART_GR1_MES02 = PART_GR1_MES02;
    }

    public float getPART_GR1_MES03() {
        return PART_GR1_MES03;
    }

    public void setPART_GR1_MES03(float PART_GR1_MES03) {
        this.PART_GR1_MES03 = PART_GR1_MES03;
    }

    public float getPART_GR1_MES04() {
        return PART_GR1_MES04;
    }

    public void setPART_GR1_MES04(float PART_GR1_MES04) {
        this.PART_GR1_MES04 = PART_GR1_MES04;
    }

    public float getPART_GR1_MES05() {
        return PART_GR1_MES05;
    }

    public void setPART_GR1_MES05(float PART_GR1_MES05) {
        this.PART_GR1_MES05 = PART_GR1_MES05;
    }

    public float getPART_GR1_MES06() {
        return PART_GR1_MES06;
    }

    public void setPART_GR1_MES06(float PART_GR1_MES06) {
        this.PART_GR1_MES06 = PART_GR1_MES06;
    }

    public float getPART_GR1_MES07() {
        return PART_GR1_MES07;
    }

    public void setPART_GR1_MES07(float PART_GR1_MES07) {
        this.PART_GR1_MES07 = PART_GR1_MES07;
    }

    public float getPART_GR1_MES08() {
        return PART_GR1_MES08;
    }

    public void setPART_GR1_MES08(float PART_GR1_MES08) {
        this.PART_GR1_MES08 = PART_GR1_MES08;
    }

    public float getPART_GR1_MES09() {
        return PART_GR1_MES09;
    }

    public void setPART_GR1_MES09(float PART_GR1_MES09) {
        this.PART_GR1_MES09 = PART_GR1_MES09;
    }

    public float getPART_GR1_MES10() {
        return PART_GR1_MES10;
    }

    public void setPART_GR1_MES10(float PART_GR1_MES10) {
        this.PART_GR1_MES10 = PART_GR1_MES10;
    }

    public float getPART_GR1_MES11() {
        return PART_GR1_MES11;
    }

    public void setPART_GR1_MES11(float PART_GR1_MES11) {
        this.PART_GR1_MES11 = PART_GR1_MES11;
    }

    public float getPART_GR1_MES12() {
        return PART_GR1_MES12;
    }

    public void setPART_GR1_MES12(float PART_GR1_MES12) {
        this.PART_GR1_MES12 = PART_GR1_MES12;
    }

    public float getPART_GR1_MES13() {
        return PART_GR1_MES13;
    }

    public void setPART_GR1_MES13(float PART_GR1_MES13) {
        this.PART_GR1_MES13 = PART_GR1_MES13;
    }

    public float getACU_GR1_MES01() {
        return ACU_GR1_MES01;
    }

    public void setACU_GR1_MES01(float ACU_GR1_MES01) {
        this.ACU_GR1_MES01 = ACU_GR1_MES01;
    }

    public float getACU_GR1_MES02() {
        return ACU_GR1_MES02;
    }

    public void setACU_GR1_MES02(float ACU_GR1_MES02) {
        this.ACU_GR1_MES02 = ACU_GR1_MES02;
    }

    public float getACU_GR1_MES03() {
        return ACU_GR1_MES03;
    }

    public void setACU_GR1_MES03(float ACU_GR1_MES03) {
        this.ACU_GR1_MES03 = ACU_GR1_MES03;
    }

    public float getACU_GR1_MES04() {
        return ACU_GR1_MES04;
    }

    public void setACU_GR1_MES04(float ACU_GR1_MES04) {
        this.ACU_GR1_MES04 = ACU_GR1_MES04;
    }

    public float getACU_GR1_MES05() {
        return ACU_GR1_MES05;
    }

    public void setACU_GR1_MES05(float ACU_GR1_MES05) {
        this.ACU_GR1_MES05 = ACU_GR1_MES05;
    }

    public float getACU_GR1_MES06() {
        return ACU_GR1_MES06;
    }

    public void setACU_GR1_MES06(float ACU_GR1_MES06) {
        this.ACU_GR1_MES06 = ACU_GR1_MES06;
    }

    public float getACU_GR1_MES07() {
        return ACU_GR1_MES07;
    }

    public void setACU_GR1_MES07(float ACU_GR1_MES07) {
        this.ACU_GR1_MES07 = ACU_GR1_MES07;
    }

    public float getACU_GR1_MES08() {
        return ACU_GR1_MES08;
    }

    public void setACU_GR1_MES08(float ACU_GR1_MES08) {
        this.ACU_GR1_MES08 = ACU_GR1_MES08;
    }

    public float getACU_GR1_MES09() {
        return ACU_GR1_MES09;
    }

    public void setACU_GR1_MES09(float ACU_GR1_MES09) {
        this.ACU_GR1_MES09 = ACU_GR1_MES09;
    }

    public float getACU_GR1_MES10() {
        return ACU_GR1_MES10;
    }

    public void setACU_GR1_MES10(float ACU_GR1_MES10) {
        this.ACU_GR1_MES10 = ACU_GR1_MES10;
    }

    public float getACU_GR1_MES11() {
        return ACU_GR1_MES11;
    }

    public void setACU_GR1_MES11(float ACU_GR1_MES11) {
        this.ACU_GR1_MES11 = ACU_GR1_MES11;
    }

    public float getACU_GR1_MES12() {
        return ACU_GR1_MES12;
    }

    public void setACU_GR1_MES12(float ACU_GR1_MES12) {
        this.ACU_GR1_MES12 = ACU_GR1_MES12;
    }

    public float getACU_GR1_MES13() {
        return ACU_GR1_MES13;
    }

    public void setACU_GR1_MES13(float ACU_GR1_MES13) {
        this.ACU_GR1_MES13 = ACU_GR1_MES13;
    }

    public float getGERAL_MES01() {
        return GERAL_MES01;
    }

    public void setGERAL_MES01(float GERAL_MES01) {
        this.GERAL_MES01 = GERAL_MES01;
    }

    public float getGERAL_MES02() {
        return GERAL_MES02;
    }

    public void setGERAL_MES02(float GERAL_MES02) {
        this.GERAL_MES02 = GERAL_MES02;
    }

    public float getGERAL_MES03() {
        return GERAL_MES03;
    }

    public void setGERAL_MES03(float GERAL_MES03) {
        this.GERAL_MES03 = GERAL_MES03;
    }

    public float getGERAL_MES04() {
        return GERAL_MES04;
    }

    public void setGERAL_MES04(float GERAL_MES04) {
        this.GERAL_MES04 = GERAL_MES04;
    }

    public float getGERAL_MES05() {
        return GERAL_MES05;
    }

    public void setGERAL_MES05(float GERAL_MES05) {
        this.GERAL_MES05 = GERAL_MES05;
    }

    public float getGERAL_MES06() {
        return GERAL_MES06;
    }

    public void setGERAL_MES06(float GERAL_MES06) {
        this.GERAL_MES06 = GERAL_MES06;
    }

    public float getGERAL_MES07() {
        return GERAL_MES07;
    }

    public void setGERAL_MES07(float GERAL_MES07) {
        this.GERAL_MES07 = GERAL_MES07;
    }

    public float getGERAL_MES08() {
        return GERAL_MES08;
    }

    public void setGERAL_MES08(float GERAL_MES08) {
        this.GERAL_MES08 = GERAL_MES08;
    }

    public float getGERAL_MES09() {
        return GERAL_MES09;
    }

    public void setGERAL_MES09(float GERAL_MES09) {
        this.GERAL_MES09 = GERAL_MES09;
    }

    public float getGERAL_MES10() {
        return GERAL_MES10;
    }

    public void setGERAL_MES10(float GERAL_MES10) {
        this.GERAL_MES10 = GERAL_MES10;
    }

    public float getGERAL_MES11() {
        return GERAL_MES11;
    }

    public void setGERAL_MES11(float GERAL_MES11) {
        this.GERAL_MES11 = GERAL_MES11;
    }

    public float getGERAL_MES12() {
        return GERAL_MES12;
    }

    public void setGERAL_MES12(float GERAL_MES12) {
        this.GERAL_MES12 = GERAL_MES12;
    }

    public float getGERAL_MES13() {
        return GERAL_MES13;
    }

    public void setGERAL_MES13(float GERAL_MES13) {
        this.GERAL_MES13 = GERAL_MES13;
    }

    public float getPARTICIPACAO_GERAL_MES01() {
        return PARTICIPACAO_GERAL_MES01;
    }

    public void setPARTICIPACAO_GERAL_MES01(float PARTICIPACAO_GERAL_MES01) {
        this.PARTICIPACAO_GERAL_MES01 = PARTICIPACAO_GERAL_MES01;
    }

    public float getPARTICIPACAO_GERAL_MES02() {
        return PARTICIPACAO_GERAL_MES02;
    }

    public void setPARTICIPACAO_GERAL_MES02(float PARTICIPACAO_GERAL_MES02) {
        this.PARTICIPACAO_GERAL_MES02 = PARTICIPACAO_GERAL_MES02;
    }

    public float getPARTICIPACAO_GERAL_MES03() {
        return PARTICIPACAO_GERAL_MES03;
    }

    public void setPARTICIPACAO_GERAL_MES03(float PARTICIPACAO_GERAL_MES03) {
        this.PARTICIPACAO_GERAL_MES03 = PARTICIPACAO_GERAL_MES03;
    }

    public float getPARTICIPACAO_GERAL_MES04() {
        return PARTICIPACAO_GERAL_MES04;
    }

    public void setPARTICIPACAO_GERAL_MES04(float PARTICIPACAO_GERAL_MES04) {
        this.PARTICIPACAO_GERAL_MES04 = PARTICIPACAO_GERAL_MES04;
    }

    public float getPARTICIPACAO_GERAL_MES05() {
        return PARTICIPACAO_GERAL_MES05;
    }

    public void setPARTICIPACAO_GERAL_MES05(float PARTICIPACAO_GERAL_MES05) {
        this.PARTICIPACAO_GERAL_MES05 = PARTICIPACAO_GERAL_MES05;
    }

    public float getPARTICIPACAO_GERAL_MES06() {
        return PARTICIPACAO_GERAL_MES06;
    }

    public void setPARTICIPACAO_GERAL_MES06(float PARTICIPACAO_GERAL_MES06) {
        this.PARTICIPACAO_GERAL_MES06 = PARTICIPACAO_GERAL_MES06;
    }

    public float getPARTICIPACAO_GERAL_MES07() {
        return PARTICIPACAO_GERAL_MES07;
    }

    public void setPARTICIPACAO_GERAL_MES07(float PARTICIPACAO_GERAL_MES07) {
        this.PARTICIPACAO_GERAL_MES07 = PARTICIPACAO_GERAL_MES07;
    }

    public float getPARTICIPACAO_GERAL_MES08() {
        return PARTICIPACAO_GERAL_MES08;
    }

    public void setPARTICIPACAO_GERAL_MES08(float PARTICIPACAO_GERAL_MES08) {
        this.PARTICIPACAO_GERAL_MES08 = PARTICIPACAO_GERAL_MES08;
    }

    public float getPARTICIPACAO_GERAL_MES09() {
        return PARTICIPACAO_GERAL_MES09;
    }

    public void setPARTICIPACAO_GERAL_MES09(float PARTICIPACAO_GERAL_MES09) {
        this.PARTICIPACAO_GERAL_MES09 = PARTICIPACAO_GERAL_MES09;
    }

    public float getPARTICIPACAO_GERAL_MES10() {
        return PARTICIPACAO_GERAL_MES10;
    }

    public void setPARTICIPACAO_GERAL_MES10(float PARTICIPACAO_GERAL_MES10) {
        this.PARTICIPACAO_GERAL_MES10 = PARTICIPACAO_GERAL_MES10;
    }

    public float getPARTICIPACAO_GERAL_MES11() {
        return PARTICIPACAO_GERAL_MES11;
    }

    public void setPARTICIPACAO_GERAL_MES11(float PARTICIPACAO_GERAL_MES11) {
        this.PARTICIPACAO_GERAL_MES11 = PARTICIPACAO_GERAL_MES11;
    }

    public float getPARTICIPACAO_GERAL_MES12() {
        return PARTICIPACAO_GERAL_MES12;
    }

    public void setPARTICIPACAO_GERAL_MES12(float PARTICIPACAO_GERAL_MES12) {
        this.PARTICIPACAO_GERAL_MES12 = PARTICIPACAO_GERAL_MES12;
    }

    public float getPARTICIPACAO_GERAL_MES13() {
        return PARTICIPACAO_GERAL_MES13;
    }

    public void setPARTICIPACAO_GERAL_MES13(float PARTICIPACAO_GERAL_MES13) {
        this.PARTICIPACAO_GERAL_MES13 = PARTICIPACAO_GERAL_MES13;
    }

    public float getACUM_GR1_MES01() {
        return ACUM_GR1_MES01;
    }

    public void setACUM_GR1_MES01(float ACUM_GR1_MES01) {
        this.ACUM_GR1_MES01 = ACUM_GR1_MES01;
    }

    public float getACUM_GR1_MES02() {
        return ACUM_GR1_MES02;
    }

    public void setACUM_GR1_MES02(float ACUM_GR1_MES02) {
        this.ACUM_GR1_MES02 = ACUM_GR1_MES02;
    }

    public float getACUM_GR1_MES03() {
        return ACUM_GR1_MES03;
    }

    public void setACUM_GR1_MES03(float ACUM_GR1_MES03) {
        this.ACUM_GR1_MES03 = ACUM_GR1_MES03;
    }

    public float getACUM_GR1_MES04() {
        return ACUM_GR1_MES04;
    }

    public void setACUM_GR1_MES04(float ACUM_GR1_MES04) {
        this.ACUM_GR1_MES04 = ACUM_GR1_MES04;
    }

    public float getACUM_GR1_MES05() {
        return ACUM_GR1_MES05;
    }

    public void setACUM_GR1_MES05(float ACUM_GR1_MES05) {
        this.ACUM_GR1_MES05 = ACUM_GR1_MES05;
    }

    public float getACUM_GR1_MES06() {
        return ACUM_GR1_MES06;
    }

    public void setACUM_GR1_MES06(float ACUM_GR1_MES06) {
        this.ACUM_GR1_MES06 = ACUM_GR1_MES06;
    }

    public float getACUM_GR1_MES07() {
        return ACUM_GR1_MES07;
    }

    public void setACUM_GR1_MES07(float ACUM_GR1_MES07) {
        this.ACUM_GR1_MES07 = ACUM_GR1_MES07;
    }

    public float getACUM_GR1_MES08() {
        return ACUM_GR1_MES08;
    }

    public void setACUM_GR1_MES08(float ACUM_GR1_MES08) {
        this.ACUM_GR1_MES08 = ACUM_GR1_MES08;
    }

    public float getACUM_GR1_MES09() {
        return ACUM_GR1_MES09;
    }

    public void setACUM_GR1_MES09(float ACUM_GR1_MES09) {
        this.ACUM_GR1_MES09 = ACUM_GR1_MES09;
    }

    public float getACUM_GR1_MES10() {
        return ACUM_GR1_MES10;
    }

    public void setACUM_GR1_MES10(float ACUM_GR1_MES10) {
        this.ACUM_GR1_MES10 = ACUM_GR1_MES10;
    }

    public float getACUM_GR1_MES11() {
        return ACUM_GR1_MES11;
    }

    public void setACUM_GR1_MES11(float ACUM_GR1_MES11) {
        this.ACUM_GR1_MES11 = ACUM_GR1_MES11;
    }

    public float getACUM_GR1_MES12() {
        return ACUM_GR1_MES12;
    }

    public void setACUM_GR1_MES12(float ACUM_GR1_MES12) {
        this.ACUM_GR1_MES12 = ACUM_GR1_MES12;
    }

    public float getACUM_GR1_MES13() {
        return ACUM_GR1_MES13;
    }

    public void setACUM_GR1_MES13(float ACUM_GR1_MES13) {
        this.ACUM_GR1_MES13 = ACUM_GR1_MES13;
    }

	@Override
    public String toString() {
        return "ConstrutorView{" + "AGRUPAMENTO_1=" + AGRUPAMENTO_1 + ", AGRUPAMENTO_2=" + AGRUPAMENTO_2 + ", DESCRICAO_AGRUPAMENTO1=" + DESCRICAO_AGRUPAMENTO1 + ", DESCRICAO_AGRUPAMENTO2=" + DESCRICAO_AGRUPAMENTO2 + ", CURVAMES01=" + CURVAMES01 + ", CURVAMES02=" + CURVAMES02 + ", CURVAMES03=" + CURVAMES03 + ", CURVAMES04=" + CURVAMES04 + ", CURVAMES05=" + CURVAMES05 + ", CURVAMES06=" + CURVAMES06 + ", CURVAMES07=" + CURVAMES07 + ", CURVAMES08=" + CURVAMES08 + ", CURVAMES09=" + CURVAMES09 + ", CURVAMES10=" + CURVAMES10 + ", CURVAMES11=" + CURVAMES11 + ", CURVAMES12=" + CURVAMES12 + ", CURVAMES13=" + CURVAMES13 + ", CURVAGERAL=" + CURVAGERAL + ", PART_GR1=" + PART_GR1 + ", ACU_GR1=" + ACU_GR1 + ", CMV=" + CMV + ", CMV_GERAL=" + CMV_GERAL + ", CMV_PARTICIPACAO_GERAL=" + CMV_PARTICIPACAO_GERAL + ", ACUM_CMV_PARTICIPACAO_GERAL=" + ACUM_CMV_PARTICIPACAO_GERAL + ", VENDIDO=" + VENDIDO + ", VENDIDO_GR1=" + VENDIDO_GR1 + ", VENDIDO_GERAL=" + VENDIDO_GERAL + ", PARTICIPACAO_GERAL=" + PARTICIPACAO_GERAL + ", ACUM_PARTICIPACAO_GERAL=" + ACUM_PARTICIPACAO_GERAL + ", MEDIA=" + MEDIA + ", MES01=" + MES01 + ", MES02=" + MES02 + ", MES03=" + MES03 + ", MES04=" + MES04 + ", MES05=" + MES05 + ", MES06=" + MES06 + ", MES07=" + MES07 + ", MES08=" + MES08 + ", MES09=" + MES09 + ", MES10=" + MES10 + ", MES11=" + MES11 + ", MES12=" + MES12 + ", MES13=" + MES13 + ", GR1_MES01=" + GR1_MES01 + ", GR1_MES02=" + GR1_MES02 + ", GR1_MES03=" + GR1_MES03 + ", GR1_MES04=" + GR1_MES04 + ", GR1_MES05=" + GR1_MES05 + ", GR1_MES06=" + GR1_MES06 + ", GR1_MES07=" + GR1_MES07 + ", GR1_MES08=" + GR1_MES08 + ", GR1_MES09=" + GR1_MES09 + ", GR1_MES10=" + GR1_MES10 + ", GR1_MES11=" + GR1_MES11 + ", GR1_MES12=" + GR1_MES12 + ", GR1_MES13=" + GR1_MES13 + ", PART_GR1_MES01=" + PART_GR1_MES01 + ", PART_GR1_MES02=" + PART_GR1_MES02 + ", PART_GR1_MES03=" + PART_GR1_MES03 + ", PART_GR1_MES04=" + PART_GR1_MES04 + ", PART_GR1_MES05=" + PART_GR1_MES05 + ", PART_GR1_MES06=" + PART_GR1_MES06 + ", PART_GR1_MES07=" + PART_GR1_MES07 + ", PART_GR1_MES08=" + PART_GR1_MES08 + ", PART_GR1_MES09=" + PART_GR1_MES09 + ", PART_GR1_MES10=" + PART_GR1_MES10 + ", PART_GR1_MES11=" + PART_GR1_MES11 + ", PART_GR1_MES12=" + PART_GR1_MES12 + ", PART_GR1_MES13=" + PART_GR1_MES13 + ", ACU_GR1_MES01=" + ACU_GR1_MES01 + ", ACU_GR1_MES02=" + ACU_GR1_MES02 + ", ACU_GR1_MES03=" + ACU_GR1_MES03 + ", ACU_GR1_MES04=" + ACU_GR1_MES04 + ", ACU_GR1_MES05=" + ACU_GR1_MES05 + ", ACU_GR1_MES06=" + ACU_GR1_MES06 + ", ACU_GR1_MES07=" + ACU_GR1_MES07 + ", ACU_GR1_MES08=" + ACU_GR1_MES08 + ", ACU_GR1_MES09=" + ACU_GR1_MES09 + ", ACU_GR1_MES10=" + ACU_GR1_MES10 + ", ACU_GR1_MES11=" + ACU_GR1_MES11 + ", ACU_GR1_MES12=" + ACU_GR1_MES12 + ", ACU_GR1_MES13=" + ACU_GR1_MES13 + ", GERAL_MES01=" + GERAL_MES01 + ", GERAL_MES02=" + GERAL_MES02 + ", GERAL_MES03=" + GERAL_MES03 + ", GERAL_MES04=" + GERAL_MES04 + ", GERAL_MES05=" + GERAL_MES05 + ", GERAL_MES06=" + GERAL_MES06 + ", GERAL_MES07=" + GERAL_MES07 + ", GERAL_MES08=" + GERAL_MES08 + ", GERAL_MES09=" + GERAL_MES09 + ", GERAL_MES10=" + GERAL_MES10 + ", GERAL_MES11=" + GERAL_MES11 + ", GERAL_MES12=" + GERAL_MES12 + ", GERAL_MES13=" + GERAL_MES13 + ", PARTICIPACAO_GERAL_MES01=" + PARTICIPACAO_GERAL_MES01 + ", PARTICIPACAO_GERAL_MES02=" + PARTICIPACAO_GERAL_MES02 + ", PARTICIPACAO_GERAL_MES03=" + PARTICIPACAO_GERAL_MES03 + ", PARTICIPACAO_GERAL_MES04=" + PARTICIPACAO_GERAL_MES04 + ", PARTICIPACAO_GERAL_MES05=" + PARTICIPACAO_GERAL_MES05 + ", PARTICIPACAO_GERAL_MES06=" + PARTICIPACAO_GERAL_MES06 + ", PARTICIPACAO_GERAL_MES07=" + PARTICIPACAO_GERAL_MES07 + ", PARTICIPACAO_GERAL_MES08=" + PARTICIPACAO_GERAL_MES08 + ", PARTICIPACAO_GERAL_MES09=" + PARTICIPACAO_GERAL_MES09 + ", PARTICIPACAO_GERAL_MES10=" + PARTICIPACAO_GERAL_MES10 + ", PARTICIPACAO_GERAL_MES11=" + PARTICIPACAO_GERAL_MES11 + ", PARTICIPACAO_GERAL_MES12=" + PARTICIPACAO_GERAL_MES12 + ", PARTICIPACAO_GERAL_MES13=" + PARTICIPACAO_GERAL_MES13 + ", ACUM_GR1_MES01=" + ACUM_GR1_MES01 + ", ACUM_GR1_MES02=" + ACUM_GR1_MES02 + ", ACUM_GR1_MES03=" + ACUM_GR1_MES03 + ", ACUM_GR1_MES04=" + ACUM_GR1_MES04 + ", ACUM_GR1_MES05=" + ACUM_GR1_MES05 + ", ACUM_GR1_MES06=" + ACUM_GR1_MES06 + ", ACUM_GR1_MES07=" + ACUM_GR1_MES07 + ", ACUM_GR1_MES08=" + ACUM_GR1_MES08 + ", ACUM_GR1_MES09=" + ACUM_GR1_MES09 + ", ACUM_GR1_MES10=" + ACUM_GR1_MES10 + ", ACUM_GR1_MES11=" + ACUM_GR1_MES11 + ", ACUM_GR1_MES12=" + ACUM_GR1_MES12 + ", ACUM_GR1_MES13=" + ACUM_GR1_MES13 + '}';
    }

}
