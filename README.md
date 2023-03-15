# Simple Library api
## Endpoints and cUrl
#
#
- Add book
``
curl --request POST \
  --url http://localhost:8080/library/addBook \
  --header 'Content-Type: application/json' \
  --data '{
	"title" : "aaaa",
	"author" : "b"
}'
``
#
#
- Get all books
``
curl --request POST \
  --url http://localhost:8080/library/addBook \
  --header 'Content-Type: application/json' \
  --data '{
	"title" : "aaaa",
	"author" : "b"
}'
``
#
#
- Delete book
``
curl --request POST \
  --url http://localhost:8080/library/addBook \
  --header 'Content-Type: application/json' \
  --data '{
	"title" : "aaaa",
	"author" : "b"
}'
``
#
#
- Find books by title
``
curl --request GET \
  --url 'http://localhost:8080/library/findBooksByTitle?title=a'
  ``
#
#
- Update book author
``
curl --request POST \
  --url http://localhost:8080/library/updateBookAuthor \
  --header 'Content-Type: application/json' \
  --data '{
	"title" : "aaaa1",
	"newAuthor" : "b"
}'
``
