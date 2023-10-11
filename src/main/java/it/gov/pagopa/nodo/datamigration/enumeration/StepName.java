package it.gov.pagopa.nodo.datamigration.enumeration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum StepName {

    START,
    EXECUTE_QUADRATURE_SCHED_TABLE_MIGRATION,
    EXECUTE_INTERMEDIARI_PA_TABLE_MIGRATION,
    EXECUTE_PA_TABLE_MIGRATION,
    EXECUTE_STAZIONI_TABLE_MIGRATION,
    EXECUTE_PA_STAZIONE_PA_TABLE_MIGRATION,
    EXECUTE_CODIFICHE_TABLE_MIGRATION,
    EXECUTE_CODIFICHE_PA_TABLE_MIGRATION,
    EXECUTE_BINARY_FILE_TABLE_MIGRATION,
    EXECUTE_INFORMATIVE_CONTO_ACCREDITO_MASTER_TABLE_MIGRATION,
    EXECUTE_INFORMATIVE_CONTO_ACCREDITO_DETAIL_TABLE_MIGRATION,
    EXECUTE_INFORMATIVE_PA_MASTER_TABLE_MIGRATION,
    EXECUTE_INFORMATIVE_PA_DETAIL_TABLE_MIGRATION,
    EXECUTE_INFORMATIVE_PA_FASCE_TABLE_MIGRATION,
    EXECUTE_INTERMEDIARI_PSP_TABLE_MIGRATION,
    EXECUTE_PSP_TABLE_MIGRATION,
    EXECUTE_WFESP_PLUGIN_CONF_TABLE_MIGRATION,
    EXECUTE_CANALI_NODO_TABLE_MIGRATION,
    EXECUTE_CANALI_TABLE_MIGRATION,
    EXECUTE_TIPI_VERSAMENTO_TABLE_MIGRATION,
    EXECUTE_CANALE_TIPO_VERSAMENTO_TABLE_MIGRATION,
    EXECUTE_PSP_CANALE_TIPO_VERSAMENTO_TABLE_MIGRATION,
    EXECUTE_DIZIONARIO_METADATI_TABLE_MIGRATION,
    EXECUTE_CDI_MASTER_TABLE_MIGRATION,
    EXECUTE_CDI_DETAIL_TABLE_MIGRATION,
    EXECUTE_CDI_FASCIA_COSTO_SERVIZIO_TABLE_MIGRATION,
    EXECUTE_CDI_INFORMAZIONI_SERVIZIO_TABLE_MIGRATION,
    EXECUTE_CDI_PREFERENCES_TABLE_MIGRATION,
    EXECUTE_ELENCO_SERVIZI_TABLE_MIGRATION,
    EXECUTE_CDS_CATEGORIE_TABLE_MIGRATION,
    EXECUTE_CDS_SOGGETTO_TABLE_MIGRATION,
    EXECUTE_CDS_SERVIZIO_TABLE_MIGRATION,
    EXECUTE_CDS_SOGGETTO_SERVIZIO_TABLE_MIGRATION,
    EXECUTE_CONFIGURATION_KEYS_TABLE_MIGRATION,
    EXECUTE_FTP_SERVERS_TABLE_MIGRATION,
    EXECUTE_PDD_TABLE_MIGRATION,
    EXECUTE_GDE_CONFIG_TABLE_MIGRATION,
    ERROR,
    END
}
