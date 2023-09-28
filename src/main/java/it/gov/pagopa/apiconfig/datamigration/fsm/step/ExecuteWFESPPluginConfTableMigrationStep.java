package it.gov.pagopa.apiconfig.datamigration.fsm.step;

import it.gov.pagopa.apiconfig.datamigration.entity.DataMigrationDetails;
import it.gov.pagopa.apiconfig.datamigration.entity.DataMigrationStatus;
import it.gov.pagopa.apiconfig.datamigration.entity.cfg.WfespPluginConf;
import it.gov.pagopa.apiconfig.datamigration.enumeration.StepName;
import it.gov.pagopa.apiconfig.datamigration.exception.migration.MigrationErrorOnStepException;
import it.gov.pagopa.apiconfig.datamigration.exception.migration.MigrationStepException;
import it.gov.pagopa.apiconfig.datamigration.fsm.Step;
import it.gov.pagopa.apiconfig.datamigration.repository.oracle.WfespPluginConfSrcRepository;
import it.gov.pagopa.apiconfig.datamigration.repository.postgres.WfespPluginConfDestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("EXECUTE_WFESP_PLUGIN_CONF_TABLE_MIGRATION")
public class ExecuteWFESPPluginConfTableMigrationStep extends Step {

    private static final int PAGE_SIZE = 50;

    @Autowired
    WfespPluginConfSrcRepository srcRepo;

    @Autowired
    WfespPluginConfDestRepository destRepo;

    @Override
    public void executeStep() throws MigrationStepException {
        try {
            // starting migration step: update migration status
            updateDataMigrationStatusOnStart(cfgDataMigrationRepo);
            checkExecutionBlock(cfgDataMigrationRepo, true);

            // starting migration: read from source DB, then save on destination DB, until end or stop
            Pageable pageable = PageRequest.of(0, PAGE_SIZE);
            do {
                Page<WfespPluginConf> pagedEntities = srcRepo.findAll(pageable);
                List<WfespPluginConf> entities = pagedEntities.getContent();
                destRepo.saveAllAndFlush(entities);
                pageable = pagedEntities.nextPageable();
            } while(canContinueReadPages(pageable));

            // ending migration step: update migration status
            updateDataMigrationStatusOnStepEnd(cfgDataMigrationRepo);
            checkExecutionBlock(cfgDataMigrationRepo, false);

        } catch (DataAccessException e) {
            updateDataMigrationStatusOnFailure(cfgDataMigrationRepo);
            throw new MigrationErrorOnStepException(getStepName(), e);
        }
    }

    @Override
    public StepName getNextState() {
        return StepName.EXECUTE_FTP_SERVERS_TABLE_MIGRATION;
    }

    @Override
    public String getStepName() {
        return StepName.EXECUTE_WFESP_PLUGIN_CONF_TABLE_MIGRATION.toString();
    }

    @Override
    public DataMigrationStatus getDataMigrationStatus(DataMigrationDetails details) {
        return details.getWfespPluginConf();
    }
}
