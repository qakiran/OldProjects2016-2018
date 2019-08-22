package Lib;

public class Xpath {

			Using single attribute
			
	//tagname[@attribute-name=’value1’]
			
	//a[@href=’http://www.google.com’]
	 	 
	//input[@id=’name’]
	 
	//input[@name=’username’]
	  
	//img[@alt=’sometext’]
		
			Using multiple attribute
	
	//tagname[@attribute1=’value1’][attribute2=’value2’]
	 	 
	//a[@id=’id1’][@name=’namevalue1’]
	 
	//img[@src=’’][@href=’’]
	
		
			Using contains method
	
	//tagname[contains(@attribute,’value1’)]
	 
	//input[contains(@id,’’)]
	 
	//input[contains(@name,’’)]
	 
	//a[contains(@href,’’)]
	 
	//img[contains(@src,’’)]
	 
	//div[contains(@id,’’)]
	
			
			Using starts-with method
	
	//tagname[starts-with(@attribute-name,’’)]
	 
	//id[starts-with(@id,’’)]
	 
	//a[starts-with(@href=’’)]
	 
	//img[starts-with(@src=’’)]
	 
	//div[starts-with(@id=’’)]
	 
	//input[starts-with(@id=’’)]
	 
	//button[starts-with(@id,’’)]
		
			Using Following node
	
	//Xpath/following::again-ur-regular-path
 
	//input[@id=’’]/following::input[1]
 
	//a[@href=’’]/following::a[1]
 
	//img[@src=’’]/following::img[1]
	
			Using preceding node
	
	//Xpath/preceding::again-ur-regular-path
		 
	//input[@id=’’]/ preceding::input[1]
		 
	//a[@href=’’]/ preceding::a[1]
		 
	//img[@src=’’]/ preceding::img[1]	
	
			Absolute XPath method
	
	//parent-xpath/absolute xpath
 
	//input[@id=’section’]/div/input
	
//------------------------------------------------------------------------------------------
	
//	AxisName			Result
//	ancestor			Selects all ancestors (parent, grandparent, etc.) of the current node
//	ancestor-or-self	Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
//	attribute			Selects all attributes of the current node
//	child				Selects all children of the current node
//	descendant			Selects all descendants (children, grandchildren, etc.) of the current node
//	descendant-or-self	Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
//	following			Selects everything in the document after the closing tag of the current node
//	following-sibling	Selects all siblings after the current node
//	namespace			Selects all namespace nodes of the current node
//	parent				Selects the parent of the current node
//	preceding			Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes and namespace nodes
//	preceding-sibling	Selects all siblings before the current node
//	self				Selects the current node

//------------------------------------------------------------------------------------------
	
}
