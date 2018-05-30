java 8

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fibonacci
{
   public static void main(String[] args) {
	Apple one = new Apple("a",32);
	Apple two = new Apple("b",44);
	Apple three = new Apple("c",11);
	Apple four = new Apple("d",55);
	Apple five = new Apple("e",22);
		
	ArrayList<Apple> list = new ArrayList<Apple>();
	list.add(five);
	list.add(three);
	list.add(one);
	list.add(four);
	list.add(two);
	
	//to sort string use compareTo
	/*Collections.sort(list, new Comparator<Apple>() {
		public int compare(Apple a1, Apple a2){
		return a1.getName().compareTo(a2.getName());
		}
		});*/
	// to sort a number use subtraction
	/*Collections.sort(list, new Comparator<Apple>() {
		public int compare(Apple a1, Apple a2){
		return a1.getCost() - a2.getCost();
		}
		});*/
	
	
 	/*for(Apple a:list)
		System.out.print(a.getName()+" ");*/
	
	//sort in java 8
	list.sort((Apple a1,Apple a2)->a1.getName().compareTo(a2.getName()));
	list.sort((Apple a1,Apple a2)->a1.getCost()-a2.getCost());
    
	//Apple parameter type is optional
	list.sort((a1,a2)->a1.getCost()-a2.getCost());

	
    //foreach in java 8
    list.forEach((a)->System.out.print(a.getName()+" "));
    
    Comparator<Apple> nameComparator=(a1,a2)->a1.getName().compareTo(a2.getName());
    list.sort(nameComparator);
    
    //reverse sorting 
    Comparator<Apple> nameComparator2=(a1,a2)->a1.getName().compareTo(a2.getName());
    list.sort(nameComparator2.reversed());
}
 
}

2.Iteration of map and list

	Map<String, Integer> map = new HashMap<>();
	map.put("A", 10);
	map.put("B", 20);
	map.put("C", 30);
	map.put("D", 40);
	map.put("E", 50);
	map.put("F", 60);
	
    //list.forEach(a->System.out.print(a.getName()+" "));
	map.forEach((k,v)->System.out.println(" key "+k+" value "+v+" "));
	
	//can open braces for further computations
	map.forEach((k,v)->{
		System.out.println("key"+k+"value"+v);
		if(k.equals("D")){
			System.out.println("D is present");
		}
	});
	//braces in list forEach
	list.forEach(item->{
		if("c".equals(item.getName())){
			System.out.println(item.toString());
		}
	});
	//below two are kind of equal
	list.forEach(System.out::println);
	System.out.println(list);
	
	//list.stream().filter(
	
	list.stream()
	.filter(s->s.getName().contains("B"))
	.forEach(System.out::println);

2.Streams filter
  
  -Streams filter() and collect()

  -collect() to convert a stream into a List.

  List<Person> ps = persons.stream().filter(a->!"mkyong".equals(a.getName())).collect(Collectors.toList()); //retruns list
   
  - .findAny().orElse (null) to return an object conditional.     
  Person p= persons.stream().filter(a->!"mkyong".equals(a.getName())).findAny().orElse(null); //returns a single object

  -map     map is used to apply a function
  String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String //map is used to apply a function //return a single property using map
                .findAny() 
                .orElse("");

- List of objects -> List of String

        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());

- List of objects -> List of other objects

 // convert inside the map() method directly.
        List<StaffPublic> result = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            return obj;
        }).collect(Collectors.toList());

-Java 8 – Stream Collectors groupingBy examples
List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

//no filters and there is groupBy in Collectors
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
-Add sorting to above
  //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

2. List Objects
Examples to ‘group by’ a list of user defined Objects.

 Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);

output

//Group by + Count
{
	papaya=1, banana=2, apple=3, orang=1, watermelon=1
}

//Group by + Sum qty
{
	papaya=20, banana=30, apple=40, orang=10, watermelon=10
}

	//group by price
        Map<BigDecimal, List<Item>> groupByPriceMap = 
			items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println(result);

        {
	19.99=[
			Item{name='banana', qty=20, price=19.99}, 
			Item{name='banana', qty=10, price=19.99}
		], 
	29.99=[
			Item{name='orang', qty=10, price=29.99}, 
			Item{name='watermelon', qty=10, price=29.99}
		], 
	9.99=[
			Item{name='apple', qty=10, price=9.99}, 
			Item{name='papaya', qty=20, price=9.99}, 
			Item{name='apple', qty=10, price=9.99}, 
			Item{name='apple', qty=20, price=9.99}
		]
}

//group by + mapping to Set
{
	19.99=[banana], 
	29.99=[orang, watermelon], 
	9.99=[papaya, apple]
}