import requests
import unittest

def read_users_from_webapi():
    # URL to fetch the data from
    url = "https://jsonplaceholder.typicode.com/users"

    # Send a GET request to the URL
    response = requests.get(url)

    # Check if the request was successful (status code 200)
    if response.status_code == 200:
        # Parse the JSON response into a list
        data_list = response.json()
        # Print the data list to verify the content
        return data_list
    else:
        print(f"Failed to fetch data. Status code: {response.status_code}")
        return ""

class TestWebApiUsers(unittest.TestCase):

    def setUp(self):
        self.users = read_users_from_webapi()

    def test_user_count(self):
        self.assertEqual(10, len(self.users))

    def test_keebler_llc_user_count(self):
        """
        Test that exactly one user is from the company 'Keebler LLC'.
        """
        keebler_users = [user for user in self.users if user['company']['name'] == 'Keebler LLC']
        self.assertEqual(len(keebler_users), 1, "There should be exactly one user from 'Keebler LLC'")

    def test_user_ids_sequential(self):
        """
        Test that user IDs are sequential starting from one.
        """
        user_ids = [user['id'] for user in self.users]
        expected_ids = list(range(1, len(self.users) + 1))
        self.assertEqual(user_ids, expected_ids, "User IDs should be sequential starting from one")

if __name__ == '__main__':
    unittest.main()