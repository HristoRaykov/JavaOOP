import core.Engine;
import interfaces.Reader;
import interfaces.Repository;
import interfaces.Writer;
import models.Blob;
import observers.Subject;
import repositories.BlobRepository;
import utils.ConsoleReader;
import utils.ConsoleWriter;
import utils.ReportEventFlag;

public class Main {
	
	public static void main(String[] args) {

		Reader reader = new ConsoleReader();
		Writer writer = new ConsoleWriter();
		Repository<Blob> repository = new BlobRepository();
		ReportEventFlag reportEventFlag = new ReportEventFlag();

		Subject subject = new Subject();

		Engine engine = new Engine(reader,writer,repository,subject,reportEventFlag);

		engine.run();
	}
}
