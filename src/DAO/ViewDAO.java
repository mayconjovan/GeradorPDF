/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.CalculoCurvaAbc;
import Domain.ConstrutorView;
import Domain.FiltrosParametros;
import Utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trabalho
 */
public class ViewDAO {

    Connection connection;

    public ViewDAO() {
        connection = ConnectionFactory.getConnetion();
    }

    public static ArrayList<ConstrutorView> buscarDados(FiltrosParametros filtros) {
        System.out.println("Entrando no Busca");
        Connection con = ConnectionFactory.getConnetion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ConstrutorView> views = new ArrayList<>();
// <editor-fold>
        try {
            String SQL = "   select acumulado_gr1.agrupamento_1\n"
                    + "        , acumulado_gr1.agrupamento_2\n"
                    + "        \n"
                    + "        , round(acumulado_gr1.vendido,4) vendido\n"
                    + "        , round(acumulado_gr1.vendido_gr1,4) vendido_gr1\n"
                    + "        , round(acumulado_gr1.part_gr1,4) part_gr1\n"
                    + "        , round(acumulado_gr1.acu_gr1,4) acu_gr1\n"
                    + "        \n"
                    + "        , round(acumulado_gr1.vendido_geral,4) vendido_geral\n"
                    + "        , round(acumulado_gr1.participacao_geral,4) participacao_geral\n"
                    + "        , round(SUM(SUM(acumulado_gr1.participacao_geral)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4) acum_participacao_geral\n"
                    + "        \n"
                    + "        , round(acumulado_gr1.cmv,4) cmv\n"
                    + "        , round(acumulado_gr1.cmv_geral,4) cmv_geral\n"
                    + "        , round(acumulado_gr1.cmv_participacao_geral,4) cmv_participacao_geral\n"
                    + "        , round(SUM(SUM(acumulado_gr1.cmv_participacao_geral)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4) acum_cmv_participacao_geral\n"
                    + "       \n"
                    + "        , round(acumulado_gr1.media,4) media\n"
                    + "        \n"
                    + "          , round(min(acumulado_gr1.mes01),4) mes01           , round(min(acumulado_gr1.mes02),4) mes02             , round(min(acumulado_gr1.mes03),4) mes03     \n"
                    + "          , round(min(acumulado_gr1.mes04),4) mes04           , round(min(acumulado_gr1.mes05),4) mes05             , round(min(acumulado_gr1.mes06),4) mes06     \n"
                    + "          , round(min(acumulado_gr1.mes07),4) mes07           , round(min(acumulado_gr1.mes08),4) mes08             , round(min(acumulado_gr1.mes09),4) mes09     \n"
                    + "          , round(min(acumulado_gr1.mes10),4) mes10           , round(min(acumulado_gr1.mes11),4) mes11             , round(min(acumulado_gr1.mes12),4) mes12\n"
                    + "          , round(min(acumulado_gr1.mes13),4) mes13\n"
                    + "\n"
                    + "            , round(min(acumulado_gr1.gr1_mes01),4) gr1_mes01   , round(min(acumulado_gr1.gr1_mes02),4) gr1_mes02     , round(min(acumulado_gr1.gr1_mes03),4) gr1_mes03     \n"
                    + "            , round(min(acumulado_gr1.gr1_mes04),4) gr1_mes04   , round(min(acumulado_gr1.gr1_mes05),4) gr1_mes05     , round(min(acumulado_gr1.gr1_mes06),4) gr1_mes06     \n"
                    + "          , round(min(acumulado_gr1.gr1_mes07),4) gr1_mes07   , round(min(acumulado_gr1.gr1_mes08),4) gr1_mes08     , round(min(acumulado_gr1.gr1_mes09),4) gr1_mes09     \n"
                    + "          , round(min(acumulado_gr1.gr1_mes10),4) gr1_mes10   , round(min(acumulado_gr1.gr1_mes11),4) gr1_mes11     , round(min(acumulado_gr1.gr1_mes12),4) gr1_mes12\n"
                    + "          , round(min(acumulado_gr1.gr1_mes13),4) gr1_mes13                 \n"
                    + "        \n"
                    + "            , round(min(acumulado_gr1.part_gr1_mes01),4) part_gr1_mes01      , round(min(acumulado_gr1.part_gr1_mes02),4) part_gr1_mes02     , round(min(acumulado_gr1.part_gr1_mes03),4) part_gr1_mes03     \n"
                    + "            , round(min(acumulado_gr1.part_gr1_mes04),4) part_gr1_mes04      , round(min(acumulado_gr1.part_gr1_mes05),4) part_gr1_mes05     , round(min(acumulado_gr1.part_gr1_mes06),4) part_gr1_mes06     \n"
                    + "          , round(min(acumulado_gr1.part_gr1_mes07),4) part_gr1_mes07      , round(min(acumulado_gr1.part_gr1_mes08),4) part_gr1_mes08     , round(min(acumulado_gr1.part_gr1_mes09),4) part_gr1_mes09     \n"
                    + "          , round(min(acumulado_gr1.part_gr1_mes10),4) part_gr1_mes10      , round(min(acumulado_gr1.part_gr1_mes11),4) part_gr1_mes11     , round(min(acumulado_gr1.part_gr1_mes12),4) part_gr1_mes12\n"
                    + "          , round(min(acumulado_gr1.part_gr1_mes13),4) part_gr1_mes13\n"
                    + "\n"
                    + "            , round(min(acumulado_gr1.acu_gr1_mes01),4) acu_gr1_mes01        , round(min(acumulado_gr1.acu_gr1_mes02),4) acu_gr1_mes02       , round(min(acumulado_gr1.acu_gr1_mes03),4) acu_gr1_mes03\n"
                    + "        , round(min(acumulado_gr1.acu_gr1_mes04),4) acu_gr1_mes04        , round(min(acumulado_gr1.acu_gr1_mes05),4) acu_gr1_mes05       , round(min(acumulado_gr1.acu_gr1_mes06),4) acu_gr1_mes06\n"
                    + "        , round(min(acumulado_gr1.acu_gr1_mes07),4) acu_gr1_mes07        , round(min(acumulado_gr1.acu_gr1_mes08),4) acu_gr1_mes08       , round(min(acumulado_gr1.acu_gr1_mes09),4) acu_gr1_mes09\n"
                    + "        , round(min(acumulado_gr1.acu_gr1_mes10),4) acu_gr1_mes10        , round(min(acumulado_gr1.acu_gr1_mes11),4) acu_gr1_mes11       , round(min(acumulado_gr1.acu_gr1_mes12),4) acu_gr1_mes12\n"
                    + "        , round(min(acumulado_gr1.acu_gr1_mes13),4) acu_gr1_mes13\n"
                    + "\n"
                    + "            , round(min(acumulado_gr1.geral_mes01),4) geral_mes01        , round(min(acumulado_gr1.geral_mes02),4) geral_mes02       , round(min(acumulado_gr1.geral_mes03),4) geral_mes03     \n"
                    + "            , round(min(acumulado_gr1.geral_mes04),4) geral_mes04        , round(min(acumulado_gr1.geral_mes05),4) geral_mes05       , round(min(acumulado_gr1.geral_mes06),4) geral_mes06     \n"
                    + "          , round(min(acumulado_gr1.geral_mes07),4) geral_mes07        , round(min(acumulado_gr1.geral_mes08),4) geral_mes08       , round(min(acumulado_gr1.geral_mes09),4) geral_mes09     \n"
                    + "          , round(min(acumulado_gr1.geral_mes10),4) geral_mes10        , round(min(acumulado_gr1.geral_mes11),4) geral_mes11       , round(min(acumulado_gr1.geral_mes12),4) geral_mes12\n"
                    + "          , round(min(acumulado_gr1.geral_mes13),4) geral_mes13\n"
                    + "        \n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes01),4) participacao_geral_mes01            , round(min(acumulado_gr1.participacao_geral_mes02),4) participacao_geral_mes02     \n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes03),4) participacao_geral_mes03            , round(min(acumulado_gr1.participacao_geral_mes04),4) participacao_geral_mes04\n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes05),4) participacao_geral_mes05            , round(min(acumulado_gr1.participacao_geral_mes06),4) participacao_geral_mes06     \n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes07),4) participacao_geral_mes07            , round(min(acumulado_gr1.participacao_geral_mes08),4) participacao_geral_mes08\n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes09),4) participacao_geral_mes09            , round(min(acumulado_gr1.participacao_geral_mes10),4) participacao_geral_mes10     \n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes11),4) participacao_geral_mes11            , round(min(acumulado_gr1.participacao_geral_mes12),4) participacao_geral_mes12\n"
                    + "          , round(min(acumulado_gr1.participacao_geral_mes13),4) participacao_geral_mes13\n"
                    + "\n"
                    + "            , round(sum(sum(acumulado_gr1.participacao_geral_mes01)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes01     \n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes02)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes02\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes03)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes03\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes04)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes04\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes05)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes05\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes06)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes06\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes07)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes07\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes08)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes08\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes09)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes09\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes10)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes10\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes11)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes11\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes12)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes12\n"
                    + "        , round(sum(sum(acumulado_gr1.participacao_geral_mes13)) OVER (ORDER BY 3 desc ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW),4)  acum_gr1_mes13\n"
                    + "\n"
                    + "          , acumulado_gr1.descricao_agrupamento1 , acumulado_gr1.descricao_agrupamento2\n"
                    + "          from          \n"
                    + "                (select somas_gerais.agrupamento_1\n"
                    + "                     , somas_gerais.agrupamento_2\n"
                    + "                     \n"
                    + "                     , min(somas_gerais.vendido) vendido\n"
                    + "                     , min(somas_gerais.vendido_gr1) as vendido_gr1\n"
                    + "                     , min(somas_gerais.part_gr1) part_gr1\n"
                    + "                     , sum(sum(somas_gerais.part_gr1)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1\n"
                    + "                     , min(somas_gerais.vendido_geral) vendido_geral\n"
                    + "                     , min(somas_gerais.participacao_geral) participacao_geral\n"
                    + "                     \n"
                    + "                     , min(somas_gerais.cmv) cmv\n"
                    + "                     , min(somas_gerais.cmv_geral) cmv_geral\n"
                    + "                     , min(somas_gerais.cmv_participacao_geral) cmv_participacao_geral\n"
                    + "                     \n"
                    + "                     , min(somas_gerais.media) media\n"
                    + "                     \n"
                    + "                     , min(somas_gerais.mes01) mes01                 , min(somas_gerais.mes02) mes02                , min(somas_gerais.mes03) mes03     \n"
                    + "                     , min(somas_gerais.mes04) mes04                 , min(somas_gerais.mes05) mes05                , min(somas_gerais.mes06) mes06     \n"
                    + "                     , min(somas_gerais.mes07) mes07                 , min(somas_gerais.mes08) mes08                , min(somas_gerais.mes09) mes09     \n"
                    + "                     , min(somas_gerais.mes10) mes10                 , min(somas_gerais.mes11) mes11                , min(somas_gerais.mes12) mes12\n"
                    + "                     , min(somas_gerais.mes13) mes13\n"
                    + "\n"
                    + "                               , min(somas_gerais.gr1_mes01) gr1_mes01         , min(somas_gerais.gr1_mes02) gr1_mes02        , min(somas_gerais.gr1_mes03) gr1_mes03     \n"
                    + "                               , min(somas_gerais.gr1_mes04) gr1_mes04         , min(somas_gerais.gr1_mes05) gr1_mes05        , min(somas_gerais.gr1_mes06) gr1_mes06     \n"
                    + "                     , min(somas_gerais.gr1_mes07) gr1_mes07         , min(somas_gerais.gr1_mes08) gr1_mes08        , min(somas_gerais.gr1_mes09) gr1_mes09     \n"
                    + "                     , min(somas_gerais.gr1_mes10) gr1_mes10         , min(somas_gerais.gr1_mes11) gr1_mes11        , min(somas_gerais.gr1_mes12) gr1_mes12\n"
                    + "                     , min(somas_gerais.gr1_mes13) gr1_mes13                    \n"
                    + "                    \n"
                    + "                               , min(somas_gerais.part_gr1_mes01) part_gr1_mes01              , min(somas_gerais.part_gr1_mes02) part_gr1_mes02     \n"
                    + "                               , min(somas_gerais.part_gr1_mes03) part_gr1_mes03              , min(somas_gerais.part_gr1_mes04) part_gr1_mes04\n"
                    + "                     , min(somas_gerais.part_gr1_mes05) part_gr1_mes05              , min(somas_gerais.part_gr1_mes06) part_gr1_mes06     \n"
                    + "                     , min(somas_gerais.part_gr1_mes07) part_gr1_mes07              , min(somas_gerais.part_gr1_mes08) part_gr1_mes08\n"
                    + "                     , min(somas_gerais.part_gr1_mes09) part_gr1_mes09              , min(somas_gerais.part_gr1_mes10) part_gr1_mes10     \n"
                    + "                     , min(somas_gerais.part_gr1_mes11) part_gr1_mes11              , min(somas_gerais.part_gr1_mes12) part_gr1_mes12\n"
                    + "                     , min(somas_gerais.part_gr1_mes13) part_gr1_mes13\n"
                    + "\n"
                    + "                               , sum(sum(somas_gerais.part_gr1_mes01)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes01     \n"
                    + "                               , sum(sum(somas_gerais.part_gr1_mes02)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes02     \n"
                    + "                               , sum(sum(somas_gerais.part_gr1_mes03)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes03     \n"
                    + "                               , sum(sum(somas_gerais.part_gr1_mes04)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes04\n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes05)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes05     \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes06)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes06     \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes07)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes07    \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes08)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes08\n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes09)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes09     \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes10)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes10    \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes11)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes11    \n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes12)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes12\n"
                    + "                     , sum(sum(somas_gerais.part_gr1_mes13)) OVER (PARTITION BY somas_gerais.agrupamento_1 ORDER BY 5 ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)  acu_gr1_mes13\n"
                    + "\n"
                    + "                               , min(somas_gerais.geral_mes01) geral_mes01           , min(somas_gerais.geral_mes02) geral_mes02          , min(somas_gerais.geral_mes03) geral_mes03     \n"
                    + "                               , min(somas_gerais.geral_mes04) geral_mes04           , min(somas_gerais.geral_mes05) geral_mes05          , min(somas_gerais.geral_mes06) geral_mes06     \n"
                    + "                     , min(somas_gerais.geral_mes07) geral_mes07           , min(somas_gerais.geral_mes08) geral_mes08          , min(somas_gerais.geral_mes09) geral_mes09     \n"
                    + "                     , min(somas_gerais.geral_mes10) geral_mes10           , min(somas_gerais.geral_mes11) geral_mes11          , min(somas_gerais.geral_mes12) geral_mes12\n"
                    + "                     , min(somas_gerais.geral_mes13) geral_mes13\n"
                    + "                    \n"
                    + "                     , min(somas_gerais.participacao_geral_mes01) participacao_geral_mes01             , min(somas_gerais.participacao_geral_mes02) participacao_geral_mes02     \n"
                    + "                     , min(somas_gerais.participacao_geral_mes03) participacao_geral_mes03             , min(somas_gerais.participacao_geral_mes04) participacao_geral_mes04\n"
                    + "                     , min(somas_gerais.participacao_geral_mes05) participacao_geral_mes05             , min(somas_gerais.participacao_geral_mes06) participacao_geral_mes06     \n"
                    + "                     , min(somas_gerais.participacao_geral_mes07) participacao_geral_mes07             , min(somas_gerais.participacao_geral_mes08) participacao_geral_mes08\n"
                    + "                     , min(somas_gerais.participacao_geral_mes09) participacao_geral_mes09             , min(somas_gerais.participacao_geral_mes10) participacao_geral_mes10     \n"
                    + "                     , min(somas_gerais.participacao_geral_mes11) participacao_geral_mes11             , min(somas_gerais.participacao_geral_mes12) participacao_geral_mes12\n"
                    + "                     , min(somas_gerais.participacao_geral_mes13) participacao_geral_mes13\n"
                    + "                      \n"
                    + "                     , somas_gerais.descricao_agrupamento1 , somas_gerais.descricao_agrupamento2\n"
                    + "                      from \n"
                    + "                        (\n"
                    + "                         select base_sql.agrupamento_1\n"
                    + "                              , base_sql.agrupamento_2  \n"
                    + "                              \n"
                    + "                              , min(base_sql.vendido) vendido\n"
                    + "                              , min(base_sql.vendido_geral) vendido_geral\n"
                    + "                              , min(base_sql.participacao_geral) participacao_geral\n"
                    + "                              \n"
                    + "                              , sum(sum(base_sql.vendido)) OVER (PARTITION BY base_sql.agrupamento_1) as vendido_gr1\n"
                    + "                              , sum(base_sql.vendido) / sum(sum(base_sql.vendido)) OVER (PARTITION BY base_sql.agrupamento_1)*100 part_gr1\n"
                    + "                              \n"
                    + "                              , min(base_sql.cmv) cmv\n"
                    + "                              , min(base_sql.cmv_geral) cmv_geral\n"
                    + "                              , min(base_sql.cmv / decode(base_sql.cmv_geral,0,1,base_sql.cmv_geral) * 100) cmv_participacao_geral\n"
                    + "                              \n"
                    + "                              , min(base_sql.media) media\n"
                    + "\n"
                    + "                              , min(base_sql.mes01) mes01                     , min(base_sql.mes02) mes02                    , min(base_sql.mes03) mes03     \n"
                    + "                              , min(base_sql.mes04) mes04                     , min(base_sql.mes05) mes05                    , min(base_sql.mes06) mes06     \n"
                    + "                              , min(base_sql.mes07) mes07                     , min(base_sql.mes08) mes08                    , min(base_sql.mes09) mes09     \n"
                    + "                              , min(base_sql.mes10) mes10                     , min(base_sql.mes11) mes11                    , min(base_sql.mes12) mes12\n"
                    + "                              , min(base_sql.mes13) mes13\n"
                    + "\n"
                    + "                              , min(base_sql.geral_mes01) geral_mes01         , min(base_sql.geral_mes02) geral_mes02        , min(base_sql.geral_mes03) geral_mes03     \n"
                    + "                              , min(base_sql.geral_mes04) geral_mes04         , min(base_sql.geral_mes05) geral_mes05        , min(base_sql.geral_mes06) geral_mes06     \n"
                    + "                              , min(base_sql.geral_mes07) geral_mes07         , min(base_sql.geral_mes08) geral_mes08        , min(base_sql.geral_mes09) geral_mes09     \n"
                    + "                              , min(base_sql.geral_mes10) geral_mes10         , min(base_sql.geral_mes11) geral_mes11        , min(base_sql.geral_mes12) geral_mes12\n"
                    + "                              , min(base_sql.geral_mes13) geral_mes13\n"
                    + "\n"
                    + "                              , min(base_sql.mes01 / base_sql.geral_mes01 * 100) participacao_geral_mes01              , min(base_sql.mes02 / base_sql.geral_mes02 * 100) participacao_geral_mes02     \n"
                    + "                              , min(base_sql.mes03 / base_sql.geral_mes03 * 100) participacao_geral_mes03              , min(base_sql.mes04 / base_sql.geral_mes04 * 100) participacao_geral_mes04\n"
                    + "                              , min(base_sql.mes05 / base_sql.geral_mes05 * 100) participacao_geral_mes05              , min(base_sql.mes06 / base_sql.geral_mes06 * 100) participacao_geral_mes06     \n"
                    + "                              , min(base_sql.mes07 / base_sql.geral_mes07 * 100) participacao_geral_mes07              , min(base_sql.mes08 / base_sql.geral_mes08 * 100) participacao_geral_mes08\n"
                    + "                              , min(base_sql.mes09 / base_sql.geral_mes09 * 100) participacao_geral_mes09              , min(base_sql.mes10 / base_sql.geral_mes10 * 100) participacao_geral_mes10     \n"
                    + "                              , min(base_sql.mes11 / base_sql.geral_mes11 * 100) participacao_geral_mes11              , min(base_sql.mes12 / base_sql.geral_mes12 * 100) participacao_geral_mes12\n"
                    + "                              , min(base_sql.mes13 / base_sql.geral_mes13 * 100) participacao_geral_mes13\n"
                    + "\n"
                    + "                              , sum(sum(base_sql.mes01)) over (partition by base_sql.agrupamento_1) as gr1_mes01       , sum(sum(base_sql.mes02)) over (partition by base_sql.agrupamento_1) as gr1_mes02     \n"
                    + "                              , sum(sum(base_sql.mes03)) over (partition by base_sql.agrupamento_1) as gr1_mes03       , sum(sum(base_sql.mes04)) over (partition by base_sql.agrupamento_1) as gr1_mes04\n"
                    + "                              , sum(sum(base_sql.mes05)) over (partition by base_sql.agrupamento_1) as gr1_mes05       , sum(sum(base_sql.mes06)) over (partition by base_sql.agrupamento_1) as gr1_mes06     \n"
                    + "                              , sum(sum(base_sql.mes07)) over (partition by base_sql.agrupamento_1) as gr1_mes07       , sum(sum(base_sql.mes08)) over (partition by base_sql.agrupamento_1) as gr1_mes08\n"
                    + "                              , sum(sum(base_sql.mes09)) over (partition by base_sql.agrupamento_1) as gr1_mes09       , sum(sum(base_sql.mes10)) over (partition by base_sql.agrupamento_1) as gr1_mes10     \n"
                    + "                              , sum(sum(base_sql.mes11)) over (partition by base_sql.agrupamento_1) as gr1_mes11       , sum(sum(base_sql.mes12)) over (partition by base_sql.agrupamento_1) as gr1_mes12\n"
                    + "                              , sum(sum(base_sql.mes13)) over (partition by base_sql.agrupamento_1) as gr1_mes13\n"
                    + "\n"
                    + "                              , sum(base_sql.mes01) / sum(sum(decode(base_sql.mes01,0,1,base_sql.mes01))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes01     \n"
                    + "                              , sum(base_sql.mes02) / sum(sum(decode(base_sql.mes02,0,1,base_sql.mes02))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes02     \n"
                    + "                              , sum(base_sql.mes03) / sum(sum(decode(base_sql.mes03,0,1,base_sql.mes03))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes03     \n"
                    + "                              , sum(base_sql.mes04) / sum(sum(decode(base_sql.mes04,0,1,base_sql.mes04))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes04\n"
                    + "                              , sum(base_sql.mes05) / sum(sum(decode(base_sql.mes05,0,1,base_sql.mes05))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes05     \n"
                    + "                              , sum(base_sql.mes06) / sum(sum(decode(base_sql.mes06,0,1,base_sql.mes06))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes06     \n"
                    + "                              , sum(base_sql.mes07) / sum(sum(decode(base_sql.mes07,0,1,base_sql.mes07))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes07     \n"
                    + "                              , sum(base_sql.mes08) / sum(sum(decode(base_sql.mes08,0,1,base_sql.mes08))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes08\n"
                    + "                              , sum(base_sql.mes09) / sum(sum(decode(base_sql.mes09,0,1,base_sql.mes09))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes09     \n"
                    + "                              , sum(base_sql.mes10) / sum(sum(decode(base_sql.mes10,0,1,base_sql.mes10))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes10     \n"
                    + "                              , sum(base_sql.mes11) / sum(sum(decode(base_sql.mes11,0,1,base_sql.mes11))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes11     \n"
                    + "                              , sum(base_sql.mes12) / sum(sum(decode(base_sql.mes12,0,1,base_sql.mes12))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes12\n"
                    + "                              , sum(base_sql.mes13) / sum(sum(decode(base_sql.mes13,0,1,base_sql.mes13))) over (partition by base_sql.agrupamento_1) * 100 part_gr1_mes13\n"
                    + "                              \n"
                    + "                              , base_sql.descricao_agrupamento1, base_sql.descricao_agrupamento2\n"
                    + "                            \n"
                    + "                             from \n"
                    + "                                 (select decode(" + filtros.agrupamento + "	\n"
                    + "                                         , 1, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                         , 2, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                         , 3, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||''                                    \n"
                    + "                                         , 4, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                         , 5, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||''                                    \n"
                    + "                                         , 6, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                         , 7, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2||''  \n"
                    + "                                         , 8, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                         , 9, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                         , 10,pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||'.'\n"
                    + "                                            ||pedi_110.cd_it_pe_subgrupo||'.'||pedi_110.cd_it_pe_item                                        \n"
                    + "                                         ) agrupamento_1             \n"
                    + "                              \n"
                    + "                                         , decode(" + filtros.agrupamento + "	\n"
                    + "                                         , 1,' '                                                                                             \n"
                    + "                                         , 2, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                         , 3, pedi_100.cod_rep_cliente                                                                       \n"
                    + "                                         , 4,' '                                                                                             \n"
                    + "                                         , 5, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                         , 6, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                         , 7, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                         , 8, ' '                                                                                            \n"
                    + "                                         , 9, ' '                                                                                            \n"
                    + "                                         , 10, ' '                                                                                           \n"
                    + "                                         ) agrupamento_2                       \n"
                    + "\n"
                    + "                                         , sum((      decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)))) vendido \n"
                    + "                                         , sum(sum((decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1))))) over() vendido_geral \n"
                    + "                                       \n"
                    + "                                                             , sum((      decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)))) /\n"
                    + "                                           sum(sum((decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1))))) over() * 100 participacao_geral \n"
                    + "                                                                                \n"
                    + "                                         , sum(    decode(" + filtros.qtdeValor + "	,1,0,pedi_110.qtde_pedida * (decode(" + filtros.custo + "	,1,basi_010.preco_custo,basi_010.preco_custo_info)))) cmv \n"
                    + "                                         , sum(sum(decode(" + filtros.qtdeValor + "	,1,0,pedi_110.qtde_pedida * (decode(" + filtros.custo + "	,1,basi_010.preco_custo,basi_010.preco_custo_info))))) over() cmv_geral \n"
                    + "                                                                                \n"
                    + "                                         , (sum((decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)))) / 13 media \n"
                    + "                                         \n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +370,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes01\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +340,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes02\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +310,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes03\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +280,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes04\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +250,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes05\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +220,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes06\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +190,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes07\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +160,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes08\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +130,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes09\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +100,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes10\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')   +70,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes11\n"
                    + "                                         , sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')   +40,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes12\n"
                    + "                                         , sum(decode(to_char      (pedi_100.data_entr_venda,            'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0)) mes13\n"
                    + "                                     \n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +370,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes01\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +340,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes02\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +310,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes03\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +280,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes04\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +250,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes05\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +220,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes06\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +190,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes07\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +160,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes08\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +130,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes09\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')  +100,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes10\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')   +70,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes11\n"
                    + "                                         , sum(sum(decode(to_char(trunc(pedi_100.data_entr_venda,'mm')   +40,'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes12\n"
                    + "                                         , sum(sum(decode(to_char      (pedi_100.data_entr_venda,            'yyyymm') ,to_char(trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1,'yyyymm'), decode(" + filtros.qtdeValor + "	, 1,pedi_110.qtde_pedida, 2,((pedi_110.qtde_pedida * pedi_110.valor_unitario)*(1-(pedi_110.percentual_desc /100)))) * decode(" + filtros.qtdeValor + "	,1,1,2,decode(" + filtros.agrupamento + "	,9,(1.00 - (((pedi_080.perc_icms * (100 - pedi_080.perc_reducao_icm) / 100)) + decode(" + filtros.percPis + "	,999.99,pedi_080.perc_pis," + filtros.percPis + "	) + decode(" + filtros.percCofins + "	,999.99,pedi_080.perc_cofins," + filtros.percCofins + "	)) / 100),1)),0))) over() geral_mes13\n"
                    + "\n"
                    + "                                         , decode(" + filtros.agrupamento + "	\n"
                    + "                                         , 1, pedi_020.nome_rep_cliente                                        \n"
                    + "                                         , 2, pedi_020.nome_rep_cliente            \n"
                    + "                                         , 3, basi_030.descr_referencia            \n"
                    + "                                         , 4, pedi_010.nome_cliente                                            \n"
                    + "                                         , 5, basi_030.descr_referencia            \n"
                    + "                                         , 6, pedi_020.nome_rep_cliente            \n"
                    + "                                         , 7, pedi_010.nome_cliente                \n"
                    + "                                         , 8, basi_030.descr_referencia                                        \n"
                    + "                                         , 9, basi_030.descr_referencia                                        \n"
                    + "                                         , 10,basi_010.narrativa                                               \n"
                    + "                                         ) descricao_agrupamento1 \n"
                    + "                                         , decode(" + filtros.agrupamento + "              \n"
                    + "                                         , 1, ''                                           \n"
                    + "                                         , 2, pedi_010.nome_cliente                        \n"
                    + "                                         , 3, pedi_020.nome_rep_cliente                     \n"
                    + "                                         , 4, ''                                           \n"
                    + "                                         , 5, pedi_010.nome_cliente          \n"
                    + "                                         , 6, basi_030.descr_referencia      \n"
                    + "                                         , 7, basi_030.descr_referencia          \n"
                    + "                                         , 8, ''                                        \n"
                    + "                                         , 9, ''                                        \n"
                    + "                                         , 10,''                                               \n"
                    + "                                         ) descricao_agrupamento2 \n"
                    + "                    \n"
                    + "                                      from pedi_100, pedi_110, basi_010, pedi_080, basi_030, pedi_010, basi_160, pedi_020 \n"
                    + "                                        where 1=1\n"
                    + "                                          and pedi_100.pedido_venda = pedi_110.pedido_venda\n"
                    + "                                          and pedi_110.cd_it_pe_nivel99 = basi_030.nivel_estrutura\n"
                    + "                                          and pedi_110.cd_it_pe_grupo   = basi_030.referencia\n"
                    + "                                          and pedi_110.cd_it_pe_nivel99  = basi_010.nivel_estrutura\n"
                    + "                                          and pedi_110.cd_it_pe_grupo    = basi_010.grupo_estrutura\n"
                    + "                                          and pedi_110.cd_it_pe_subgrupo = basi_010.subgru_estrutura\n"
                    + "                                          and pedi_110.cd_it_pe_item     = basi_010.item_estrutura\n"
                    + "                                          and pedi_100.natop_pv_nat_oper = pedi_080.natur_operacao\n"
                    + "                                          and pedi_100.natop_pv_est_oper = pedi_080.estado_natoper\n"
                    + "                                          and pedi_100.cli_ped_cgc_cli9 = pedi_010.cgc_9  \n"
                    + "                                          and pedi_100.cli_ped_cgc_cli4 = pedi_010.cgc_4\n"
                    + "                                          and pedi_100.cli_ped_cgc_cli2 = pedi_010.cgc_2\n"
                    + "                                          and pedi_010.cod_cidade = basi_160.cod_cidade\n"
                    + "                                          and pedi_100.cod_rep_cliente = pedi_020.cod_rep_cliente\n"
                    + "                                          \n"
                    + "                                          and pedi_100.data_entr_venda  between trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy')-370, 'mm') and trunc(trunc(to_date('30/jun/2019'	, 'dd/mm/yyyy') ,'mm')+31,'mm')-1                                  \n"
                    + "                               \n"
                    + "                                          and pedi_100.tecido_peca        =  decode(" + filtros.nivel + "	,99,pedi_100.tecido_peca,1,'1',2,'2',4,'4',7,'7',9,'9')                                                   \n"
                    + "                                          and pedi_080.faturamento        <> decode(" + filtros.faturamento + "	,0,0,1,2,2,1)                                                                                       \n"
                    + "                                          and pedi_110.cod_cancelamento <  decode('" + filtros.consideraCancelados + "','S', 1000,'N',1) \n"
                    + //"/*\n" +
                    //"                                          and (pedi_100.codigo_empresa   in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_codigo_empresa str,     '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_codigo_empresa     = '0000') \n" +
                    //"                                          and (basi_030.colecao          in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_colecao str,            '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_colecao            = '000')                                                                                                      \n" +
                    //"                                          and (basi_030.linha_produto    in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_linha_produto str,      '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_linha_produto      = '00')  \n" +
                    //"                                          and (pedi_100.cod_rep_cliente  in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_codigo_rep_cliente str, '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_codigo_rep_cliente = '0000')                                                                                                     \n" +
                    //"                                          and (pedi_100.cli_ped_cgc_cli9 in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_cnpj_9 str,             '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_cnpj_9             = '000000000')\n" +
                    //"                                          and (basi_160.estado           in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_estado_cliente str,     '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_estado_cliente     = '00') \n" +
                    //"                                          and (pedi_010.tipo_cliente     in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_tipo_cliente str,       '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_tipo_cliente       = '00') \n" +
                    //"                                          and (pedi_010.cod_cidade       in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_cod_cidade str,         '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_cod_cidade         = '0000') \n" +
                    //"                                          and (pedi_110.cd_it_pe_grupo   in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_grupo_refencia str,     '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_grupo_refencia     = '00000') \n" +
                    //"                                          and (basi_030.artigo           in (select REGEXP_SUBSTR(str, exp,1,level) lista from (select p_artigo_produto str,     '[^,]+' exp  from dual)connect by REGEXP_SUBSTR(str, exp, 1, level) is not null) or p_artigo_produto     = '0000') \n" +
                    //"  */                                        \n" +
                    "                                     group by \n"
                    + "                                              decode(" + filtros.agrupamento + "	\n"
                    + "                                              , 1, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                              , 2, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                              , 3, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||''                                    \n"
                    + "                                              , 4, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                              , 5, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||''                                    \n"
                    + "                                              , 6, pedi_100.cod_rep_cliente||''                                                                   \n"
                    + "                                              , 7, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2||''  \n"
                    + "                                              , 8, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                              , 9, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                              , 10,pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo||'.'\n"
                    + "                                                 ||pedi_110.cd_it_pe_subgrupo||'.'||pedi_110.cd_it_pe_item                                        \n"
                    + "                                              )            \n"
                    + "                                              \n"
                    + "                                              \n"
                    + "                                              , decode(" + filtros.agrupamento + "	\n"
                    + "                                              , 1,' '                                                                                             \n"
                    + "                                              , 2, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                              , 3, pedi_100.cod_rep_cliente                                                                       \n"
                    + "                                              , 4,' '                                                                                             \n"
                    + "                                              , 5, pedi_100.cli_ped_cgc_cli9||'/'||pedi_100.cli_ped_cgc_cli4||'-'||pedi_100.cli_ped_cgc_cli2      \n"
                    + "                                              , 6, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                              , 7, pedi_110.cd_it_pe_nivel99||'.'||pedi_110.cd_it_pe_grupo                                        \n"
                    + "                                              , 8, ' '                                                                                            \n"
                    + "                                              , 9, ' '                                                                                            \n"
                    + "                                              , 10, ' '                                                                                           \n"
                    + "                                              )\n"
                    + "                                              \n"
                    + "                                         , decode(" + filtros.agrupamento + "	\n"
                    + "                                         , 1, pedi_020.nome_rep_cliente                                        \n"
                    + "                                         , 2, pedi_020.nome_rep_cliente            \n"
                    + "                                         , 3, basi_030.descr_referencia            \n"
                    + "                                         , 4, pedi_010.nome_cliente                                            \n"
                    + "                                         , 5, basi_030.descr_referencia            \n"
                    + "                                         , 6, pedi_020.nome_rep_cliente            \n"
                    + "                                         , 7, pedi_010.nome_cliente                \n"
                    + "                                         , 8, basi_030.descr_referencia                                        \n"
                    + "                                         , 9, basi_030.descr_referencia                                        \n"
                    + "                                         , 10,basi_010.narrativa                                               \n"
                    + "                                         )  \n"
                    + "                                         , decode(" + filtros.agrupamento + "              \n"
                    + "                                         , 1, ''                                           \n"
                    + "                                         , 2, pedi_010.nome_cliente                        \n"
                    + "                                         , 3, pedi_020.nome_rep_cliente                     \n"
                    + "                                         , 4, ''                                           \n"
                    + "                                         , 5, pedi_010.nome_cliente          \n"
                    + "                                         , 6, basi_030.descr_referencia      \n"
                    + "                                         , 7, basi_030.descr_referencia          \n"
                    + "                                         , 8, ''                                        \n"
                    + "                                         , 9, ''                                        \n"
                    + "                                         , 10,''                                               \n"
                    + "                                         )  \n"
                    + "                                                                                                                                     \n"
                    + "                                order by 1 desc, 5 desc) base_sql \n"
                    + "\n"
                    + "                        group by base_sql.agrupamento_1\n"
                    + "                               , base_sql.agrupamento_2\n"
                    + "                               , base_sql.descricao_agrupamento1 , base_sql.descricao_agrupamento2\n"
                    + "                        order by 1 desc, 5 desc) somas_gerais \n"
                    + "\n"
                    + "        group by somas_gerais.agrupamento_1\n"
                    + "               , somas_gerais.agrupamento_2\n"
                    + "               , somas_gerais.descricao_agrupamento1, somas_gerais.descricao_agrupamento2\n"
                    + "        order by 1 desc, 5 desc) acumulado_gr1 \n"
                    + "\n"
                    + " group by acumulado_gr1.agrupamento_1\n"
                    + "        , acumulado_gr1.agrupamento_2\n"
                    + "        , acumulado_gr1.descricao_agrupamento1, acumulado_gr1.descricao_agrupamento2\n"
                    + "        \n"
                    + "        , acumulado_gr1.vendido\n"
                    + "        , acumulado_gr1.vendido_gr1\n"
                    + "        , acumulado_gr1.part_gr1\n"
                    + "        , acumulado_gr1.acu_gr1\n"
                    + "        \n"
                    + "        , acumulado_gr1.vendido_geral\n"
                    + "        , acumulado_gr1.participacao_geral\n"
                    + "\n"
                    + "        , acumulado_gr1.cmv\n"
                    + "        , acumulado_gr1.cmv_geral\n"
                    + "        , acumulado_gr1.cmv_participacao_geral\n"
                    + "\n"
                    + "        , acumulado_gr1.media\n"
                    + "\n"
                    + "        , acumulado_gr1.mes01     , acumulado_gr1.mes02    , acumulado_gr1.mes03     , acumulado_gr1.mes04\n"
                    + "        , acumulado_gr1.mes05     , acumulado_gr1.mes06    , acumulado_gr1.mes07     , acumulado_gr1.mes08\n"
                    + "        , acumulado_gr1.mes09     , acumulado_gr1.mes10    , acumulado_gr1.mes11     , acumulado_gr1.mes12\n"
                    + "        , acumulado_gr1.mes13\n"
                    + "        \n"
                    + " order by 4 desc, 3 desc\n"
                    + "        \n"
                    + "        \n"
                    + "        \n"
                    + "                        ";
// </editor-fold>
            //      System.out.println(SQL);
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ConstrutorView view = new ConstrutorView();
                CalculoCurvaAbc calc = new CalculoCurvaAbc();

                switch (filtros.agrupamento) {
                    case 1:
                    case 4:
                    case 8:
                    case 9:
                    case 10:
                        view.setAGRUPAMENTO_1(rs.getString("agrupamento_1"));
                        view.setDESCRICAO_AGRUPAMENTO1(rs.getString("descricao_agrupamento1"));
                        view.setAGRUPAMENTO_2(rs.getString("agrupamento_2"));
                        view.setDESCRICAO_AGRUPAMENTO2(rs.getString("descricao_agrupamento2"));
                        view.setMES01(rs.getInt("mes01"));
                        view.setCURVAMES01(calc.calculoAbc(rs.getFloat("participacao_geral_mes01"), rs.getFloat("acum_gr1_mes01"), filtros.curvaA, filtros.curvaB));
                        view.setMES02(rs.getInt("mes02"));
                        view.setCURVAMES02(calc.calculoAbc(rs.getFloat("participacao_geral_mes02"), rs.getFloat("acum_gr1_mes02"), filtros.curvaA, filtros.curvaB));
                        view.setMES03(rs.getInt("mes03"));
                        view.setCURVAMES03(calc.calculoAbc(rs.getFloat("participacao_geral_mes03"), rs.getFloat("acum_gr1_mes03"), filtros.curvaA, filtros.curvaB));
                        view.setMES04(rs.getInt("mes04"));
                        view.setCURVAMES04(calc.calculoAbc(rs.getFloat("participacao_geral_mes04"), rs.getFloat("acum_gr1_mes04"), filtros.curvaA, filtros.curvaB));
                        view.setMES05(rs.getInt("mes05"));
                        view.setCURVAMES05(calc.calculoAbc(rs.getFloat("participacao_geral_mes05"), rs.getFloat("acum_gr1_mes05"), filtros.curvaA, filtros.curvaB));
                        view.setMES06(rs.getInt("mes06"));
                        view.setCURVAMES06(calc.calculoAbc(rs.getFloat("participacao_geral_mes06"), rs.getFloat("acum_gr1_mes06"), filtros.curvaA, filtros.curvaB));
                        view.setMES07(rs.getInt("mes07"));
                        view.setCURVAMES07(calc.calculoAbc(rs.getFloat("participacao_geral_mes07"), rs.getFloat("acum_gr1_mes07"), filtros.curvaA, filtros.curvaB));
                        view.setMES08(rs.getInt("mes08"));
                        view.setCURVAMES08(calc.calculoAbc(rs.getFloat("participacao_geral_mes08"), rs.getFloat("acum_gr1_mes08"), filtros.curvaA, filtros.curvaB));
                        view.setMES09(rs.getInt("mes09"));
                        view.setCURVAMES09(calc.calculoAbc(rs.getFloat("participacao_geral_mes09"), rs.getFloat("acum_gr1_mes09"), filtros.curvaA, filtros.curvaB));
                        view.setMES10(rs.getInt("mes10"));
                        view.setCURVAMES10(calc.calculoAbc(rs.getFloat("participacao_geral_mes10"), rs.getFloat("acum_gr1_mes10"), filtros.curvaA, filtros.curvaB));
                        view.setMES11(rs.getInt("mes11"));
                        view.setCURVAMES11(calc.calculoAbc(rs.getFloat("participacao_geral_mes11"), rs.getFloat("acum_gr1_mes11"), filtros.curvaA, filtros.curvaB));
                        view.setMES12(rs.getInt("mes12"));
                        view.setCURVAMES12(calc.calculoAbc(rs.getFloat("participacao_geral_mes12"), rs.getFloat("acum_gr1_mes12"), filtros.curvaA, filtros.curvaB));
                        view.setMES13(rs.getInt("mes13"));
                        view.setCURVAMES13(calc.calculoAbc(rs.getFloat("participacao_geral_mes13"), rs.getFloat("acum_gr1_mes13"), filtros.curvaA, filtros.curvaB));

                        view.setVENDIDO(rs.getFloat("vendido"));
                        view.setPARTICIPACAO_GERAL(rs.getFloat("participacao_geral"));

                        view.setMEDIA(rs.getFloat("media"));

                        view.setCMV(rs.getInt("cmv"));
                        view.setCMV_GERAL(rs.getInt("cmv_geral"));
                        view.setCMV_PARTICIPACAO_GERAL(rs.getInt("cmv_participacao_geral"));

                        view.setACUM_PARTICIPACAO_GERAL(rs.getInt("acum_participacao_geral"));
                        view.setCURVAGERAL(calc.calculoAbc(rs.getFloat("participacao_geral"), rs.getFloat("acum_participacao_geral"), filtros.curvaA, filtros.curvaB));

                        views.add(view);
                        break;

                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        view.setAGRUPAMENTO_1(rs.getString("agrupamento_1"));
                        view.setDESCRICAO_AGRUPAMENTO1(rs.getString("descricao_agrupamento1"));
                        view.setAGRUPAMENTO_2(rs.getString("agrupamento_2"));
                        view.setDESCRICAO_AGRUPAMENTO2(rs.getString("descricao_agrupamento2"));

                        view.setMES01(rs.getInt("mes01"));
                        view.setCURVAMES01(calc.calculoAbc(rs.getFloat("part_gr1_mes01"), rs.getFloat("acu_gr1_mes01"), filtros.curvaA, filtros.curvaB));
                        view.setMES02(rs.getInt("mes02"));
                        view.setCURVAMES02(calc.calculoAbc(rs.getFloat("part_gr1_mes02"), rs.getFloat("acu_gr1_mes02"), filtros.curvaA, filtros.curvaB));
                        view.setMES03(rs.getInt("mes03"));
                        view.setCURVAMES03(calc.calculoAbc(rs.getFloat("part_gr1_mes03"), rs.getFloat("acu_gr1_mes03"), filtros.curvaA, filtros.curvaB));
                        view.setMES04(rs.getInt("mes04"));
                        view.setCURVAMES04(calc.calculoAbc(rs.getFloat("part_gr1_mes04"), rs.getFloat("acu_gr1_mes04"), filtros.curvaA, filtros.curvaB));
                        view.setMES05(rs.getInt("mes05"));
                        view.setCURVAMES05(calc.calculoAbc(rs.getFloat("part_gr1_mes05"), rs.getFloat("acu_gr1_mes05"), filtros.curvaA, filtros.curvaB));
                        view.setMES06(rs.getInt("mes06"));
                        view.setCURVAMES06(calc.calculoAbc(rs.getFloat("part_gr1_mes06"), rs.getFloat("acu_gr1_mes06"), filtros.curvaA, filtros.curvaB));
                        view.setMES07(rs.getInt("mes07"));
                        view.setCURVAMES07(calc.calculoAbc(rs.getFloat("part_gr1_mes07"), rs.getFloat("acu_gr1_mes07"), filtros.curvaA, filtros.curvaB));
                        view.setMES08(rs.getInt("mes08"));
                        view.setCURVAMES08(calc.calculoAbc(rs.getFloat("part_gr1_mes08"), rs.getFloat("acu_gr1_mes08"), filtros.curvaA, filtros.curvaB));
                        view.setMES09(rs.getInt("mes09"));
                        view.setCURVAMES09(calc.calculoAbc(rs.getFloat("part_gr1_mes09"), rs.getFloat("acu_gr1_mes09"), filtros.curvaA, filtros.curvaB));
                        view.setMES10(rs.getInt("mes10"));
                        view.setCURVAMES10(calc.calculoAbc(rs.getFloat("part_gr1_mes10"), rs.getFloat("acu_gr1_mes10"), filtros.curvaA, filtros.curvaB));
                        view.setMES11(rs.getInt("mes11"));
                        view.setCURVAMES11(calc.calculoAbc(rs.getFloat("part_gr1_mes11"), rs.getFloat("acu_gr1_mes11"), filtros.curvaA, filtros.curvaB));
                        view.setMES12(rs.getInt("mes12"));
                        view.setCURVAMES12(calc.calculoAbc(rs.getFloat("part_gr1_mes12"), rs.getFloat("acu_gr1_mes12"), filtros.curvaA, filtros.curvaB));
                        view.setMES13(rs.getInt("mes13"));
                        view.setCURVAMES13(calc.calculoAbc(rs.getFloat("part_gr1_mes13"), rs.getFloat("acu_gr1_mes13"), filtros.curvaA, filtros.curvaB));

                        view.setVENDIDO(rs.getFloat("vendido"));
                        view.setPART_GR1(rs.getInt("part_gr1"));

                        view.setMEDIA(rs.getFloat("media"));

                        view.setCMV(rs.getInt("cmv"));
                        view.setCMV_GERAL(rs.getInt("cmv_geral"));
                        view.setCMV_PARTICIPACAO_GERAL(rs.getInt("cmv_participacao_geral"));

                        view.setACU_GR1(rs.getInt("acu_gr1"));
                        view.setCURVAGERAL(calc.calculoAbc(rs.getFloat("part_gr1"), rs.getFloat("acu_gr1"), filtros.curvaA, filtros.curvaB));

                        views.add(view);
                        break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return views;
    }
}
