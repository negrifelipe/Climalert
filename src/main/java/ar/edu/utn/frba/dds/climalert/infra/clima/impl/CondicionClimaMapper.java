package ar.edu.utn.frba.dds.climalert.infra.clima.impl;

import ar.edu.utn.frba.dds.climalert.domain.clima.CondicionClima;

import java.util.Map;

// Te amo copilot
public class CondicionClimaMapper {
  private static final Map<Integer, CondicionClima> CODE_MAP = Map.<Integer, CondicionClima>ofEntries(
      Map.entry(1000, CondicionClima.Despejado),
      Map.entry(1003, CondicionClima.ParcialmenteNublado),
      Map.entry(1006, CondicionClima.Nublado),
      Map.entry(1009, CondicionClima.Cubierto),
      Map.entry(1012, CondicionClima.Neblina),
      Map.entry(1015, CondicionClima.Calima),
      Map.entry(1018, CondicionClima.PolvoSuspendido),
      Map.entry(1021, CondicionClima.TormentaDePolvo),
      Map.entry(1024, CondicionClima.TormentaDeArena),
      Map.entry(1027, CondicionClima.TormentaDeArenaSevera),
      Map.entry(1030, CondicionClima.Bruma),
      Map.entry(1033, CondicionClima.Humo),
      Map.entry(1036, CondicionClima.NieblaDeHumo),
      Map.entry(1039, CondicionClima.Esmog),
      Map.entry(1042, CondicionClima.EsmogSevero),
      Map.entry(1045, CondicionClima.PolvoDelSahara),
      Map.entry(1048, CondicionClima.Polvo),
      Map.entry(1063, CondicionClima.PosiblesLluviasDispersas),
      Map.entry(1066, CondicionClima.PosibleNieveDispersa),
      Map.entry(1069, CondicionClima.PosibleAguanieveDispersa),
      Map.entry(1072, CondicionClima.PosibleLloviznaCongelanteDispersa),
      Map.entry(1087, CondicionClima.PosiblesTormentasElectricas),
      Map.entry(1114, CondicionClima.NieveArrastrada),
      Map.entry(1117, CondicionClima.Ventisca),
      Map.entry(1135, CondicionClima.Niebla),
      Map.entry(1147, CondicionClima.NieblaCongelante),
      Map.entry(1150, CondicionClima.LloviznaLigeraDispersa),
      Map.entry(1153, CondicionClima.LloviznaLigera),
      Map.entry(1168, CondicionClima.LloviznaCongelante),
      Map.entry(1171, CondicionClima.LloviznaCongelanteIntensa),
      Map.entry(1180, CondicionClima.LluviaLigeraDispersa),
      Map.entry(1183, CondicionClima.LluviaLigera),
      Map.entry(1186, CondicionClima.LluviaModeradaIntermitente),
      Map.entry(1189, CondicionClima.LluviaModerada),
      Map.entry(1192, CondicionClima.LluviaIntensaIntermitente),
      Map.entry(1195, CondicionClima.LluviaIntensa),
      Map.entry(1198, CondicionClima.LluviaCongelanteLigera),
      Map.entry(1201, CondicionClima.LluviaCongelanteModeradaOIntensa),
      Map.entry(1204, CondicionClima.AguanieveLigera),
      Map.entry(1207, CondicionClima.AguanieveModeradaOIntensa),
      Map.entry(1210, CondicionClima.NieveLigeraDispersa),
      Map.entry(1213, CondicionClima.NieveLigera),
      Map.entry(1216, CondicionClima.NieveModeradaDispersa),
      Map.entry(1219, CondicionClima.NieveModerada),
      Map.entry(1222, CondicionClima.NieveIntensaDispersa),
      Map.entry(1225, CondicionClima.NieveIntensa),
      Map.entry(1237, CondicionClima.GranizoPequeno),
      Map.entry(1240, CondicionClima.ChubascoDeLluviaLigera),
      Map.entry(1243, CondicionClima.ChubascoDeLluviaModeradoOIntenso),
      Map.entry(1246, CondicionClima.ChubascoDeLluviaTorrencial),
      Map.entry(1249, CondicionClima.ChubascosDeAguanieveLigeros),
      Map.entry(1252, CondicionClima.ChubascosDeAguanieveModeradosOIntensos),
      Map.entry(1255, CondicionClima.ChubascosDeNieveLigeros),
      Map.entry(1258, CondicionClima.ChubascosDeNieveModeradosOIntensos),
      Map.entry(1261, CondicionClima.ChubascosLigerosDeGranizoPequeno),
      Map.entry(1264, CondicionClima.ChubascosModeradosOIntensosDeGranizoPequeno),
      Map.entry(1273, CondicionClima.LluviaLigeraDispersaConTruenos),
      Map.entry(1276, CondicionClima.LluviaModeradaOIntensaConTruenos),
      Map.entry(1279, CondicionClima.NieveLigeraDispersaConTruenos),
      Map.entry(1282, CondicionClima.NieveModeradaOIntensaConTruenos)
  );

  public static CondicionClima fromCode(int code) {
    var condicion = CODE_MAP.get(code);
    if (condicion == null) {
      throw new IllegalArgumentException("Código de condición climática desconocido: " + code);
    }
    return condicion;
  }
}
