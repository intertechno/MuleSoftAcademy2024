using System.Text.Json;
using System.Xml;

// find all XML files in the input folder
string inPath = @"C:\Academy\MuleSoft\Testing\In";
string[] xmlInputFiles = Directory.GetFiles(inPath, "*.xml");

foreach (string xmlInputFile in xmlInputFiles)
{
    // Load XML data from file
    string xmlData = File.ReadAllText(xmlInputFile);
    Console.WriteLine($"Converting: {xmlInputFile}...");

    // Parse the XML data
    XmlDocument xmlDoc = new XmlDocument();
    xmlDoc.LoadXml(xmlData);

    // Convert XML to dictionary
    var library = new Dictionary<string, object>
        {
            { "library", new Dictionary<string, object> { { "book", new List<Dictionary<string, string>>() } } }
        };

    XmlNodeList bookNodes = xmlDoc.SelectNodes("//book");

    foreach (XmlNode book in bookNodes)
    {
        var bookData = new Dictionary<string, string>
            {
                { "title", book["title"].InnerText },
                { "author", book["author"].InnerText },
                { "year", book["year"].InnerText }
            };

        ((List<Dictionary<string, string>>)((Dictionary<string, object>)library["library"])["book"]).Add(bookData);
    }

    // Convert dictionary to JSON
    string jsonData = JsonSerializer.Serialize(library);

    // Print JSON data
    string outputFile = Path.ChangeExtension(
        Path.GetFileName(xmlInputFile), ".json");
    string outputPath = @"C:\Academy\MuleSoft\Testing\Out";
    string jsonPath = Path.Combine(outputPath, outputFile);

    File.WriteAllText(jsonPath, jsonData);

    File.Delete(xmlInputFile);
}

