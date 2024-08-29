import unittest
import json
import xml.etree.ElementTree as ET

class TestXMLtoJSONConversion(unittest.TestCase):
    def setUp(self):
        # XML input string
        self.xml_data = """
        <library>
            <book>
                <title>Clean Code</title>
                <author>Robert C. Martin</author>
                <year>2008</year>
            </book>
            <book>
                <title>The Pragmatic Programmer</title>
                <author>Andrew Hunt</author>
                <author>Andrew Hunt</author>
                <year>1999</year>
            </book>
            <book>
                <title>Introduction to Algorithms</title>
                <author>Thomas H. Cormen</author>
                <year>2009</year>
            </book>
        </library>
        """

        # Expected JSON output as a dictionary
        self.expected_json = {
            "library": {
                "book": [
                    {
                        "title": "Clean Code",
                        "author": "Robert C. Martin",
                        "year": "2008"
                    },
                    {
                        "title": "The Pragmatic Programmer",
                        "author": "Andrew Hunt",
                        "year": "1999"
                    },
                    {
                        "title": "Introduction to Algorithms",
                        "author": "Thomas H. Cormen",
                        "year": "2009"
                    }
                ]
            }
        }

    def test_xml_to_json_conversion(self):
        # Convert the XML string to JSON using a function
        result_json = self.convert_xml_to_json(self.xml_data)

        # Compare the result JSON with the expected JSON
        self.assertEqual(result_json, self.expected_json)

    def convert_xml_to_json(self, xml_string):
        # Parse XML data
        root = ET.fromstring(xml_string)
        
        # Function to recursively convert XML to a dictionary
        def xml_to_dict(element):
            # If the element has child elements, recurse
            if len(element) > 0:
                children = {}
                for child in element:
                    if child.tag not in children:
                        children[child.tag] = []
                    children[child.tag].append(xml_to_dict(child))
                return {element.tag: {k: v[0] if len(v) == 1 else v for k, v in children.items()}}
            # If it's a leaf node, return its text
            return {element.tag: element.text.strip() if element.text else ""}
        
        # Convert XML to a dictionary
        dict_data = xml_to_dict(root)

        # Adjust nested structure for JSON output
        dict_data["library"]["book"] = [
            {k: v for d in dict_data["library"]["book"] for k, v in d.items()}
        ]
        
        return dict_data

if __name__ == '__main__':
    unittest.main()
