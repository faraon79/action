package click.tomasz.runtime;

import click.tomasz.model.CollectionResult;
import click.tomasz.model.Process;
import click.tomasz.model.Instance;


public interface ProcessService {

	CollectionResult<Process> getProcessList();
	void startProcessInstance(String id);
	void stopProcessInstance(String id);
	CollectionResult<Instance> getProcessInstanceList();
}
