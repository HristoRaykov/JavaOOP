package P07CustomList;

public class CommandInterpreter {
	
	private CustomList<String> list;
	
	public CommandInterpreter(CustomList<String> list) {
		
		this.list = list;
	}
	
	public void execute(String[] args){
		
		switch (args[0]){
			case "Add":
				list.add(args[1]);
				break;
			case "Remove":
				list.remove(Integer.valueOf(args[1]));
				break;
			case "Contains":
				System.out.println(list.contains(args[1]));
				break;
			case "Swap":
				list.swap(Integer.valueOf(args[1]),Integer.valueOf(args[2]));
				break;
			case "Greater":
				System.out.println(list.countGreaterThan(args[1]));
				break;
			case "Max":
				System.out.println(list.getMax());
				break;
			case "Min":
				System.out.println(list.getMin());
				break;
			case "Print":
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				break;
			case "END":
				System.exit(0);
				break;
		}
		
		
		
	}
	
}
