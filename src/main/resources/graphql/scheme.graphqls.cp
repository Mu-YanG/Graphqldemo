type Query {
    bookById(id: ID): Book
}
type User{
    id: ID
    name: String
    age: Int
    blance: Int
}
type Book {
    id: ID
    name: String
    pageCount: Int
    author: Author
}

type Author {
    id: ID
    firstName: String
    lastName: String
}