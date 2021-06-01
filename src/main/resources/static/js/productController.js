// Doing a product web app in product page to display the name, description, imageURL, category, price etc.

const createHTMLList = (index, imageURL, name, price) =>
`<div class="col-lg-4 col-sm-6">
    <a id="${index}" href="#" data-toggle="modal" data-target="#productModal"><div class="productCard">
        <img src=${imageURL} class="card-img-top">
        <div class="productInfo text-center">
        <b>${name}</b>
        <p class="productPrice">$${price}</p>
        </div>
    </div></a>
</div>

`;


function displayProductDetails(item) {
    document.querySelector('#modalName').innerText = item.oName;
    document.querySelector('#modalImg').src = item.oImageUrl;
    document.querySelector('#modalCategory').innerText = item.oCategory;
    document.querySelector('#modalPrice').innerText = item.oPrice;
    document.querySelector('#modalDesc').innerText = item.oDescription;
    document.querySelector('#modalQuantity').innerText = item.oQuantity;
}


class ProductsController {

    constructor() {
        this._items = [];  // Create an array to store the details of product items
    }

    // Method to add the items into the array
    addItem(name, description, imageUrl, category, price, quantity, imagePath) {

        var productController = this;

        const item = {
            name: name,
            description: description,
            imageUrl: imageUrl,
            category: category,
            price: price,
            quantity: quantity
        };

        const formData = new FormData();
        formData.append('name', name);
        formData.append('description', description);
        formData.append('imageUrl', imageUrl);
        formData.append('category', category);
        formData.append('price', price);
        formData.append('quantity', quantity);
        formData.append('imagefile', imagePath);

        fetch('http://localhost:8080/item/add', {
            method: 'POST', // or 'PUT;
            body: formData
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                alert("Successfully added to Product")
                // this.displayItem();     //To display in the table from ProductForm.html
            })
            .catch((error) => {
                console.error('Error:', error);
                alert("Error adding item to Product")
            });
    }

    // Method to fetch data from API
    displayItem() {
        // Fetch data from database using the REST API endpoint for Spring Boot
        var productController = this;     // productController refers to the class object
        productController._items = [];

        fetch('http://127.0.0.1:8080/item/all')
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);

                data.forEach(function (item, index) {

                    const itemObj = {
                                oId: item.id,
                                oName: item.name,
                                oDescription: item.description,
                                oImageUrl: item.imageUrl,
                                oCategory: item.category,
                                oPrice: item.price,
                                oQuantity: item.quantity
                            };

                productController._items.push(itemObj);     // Array push
                });

                productController.render();
            })
            .catch(function(error) {
            console.log(error);
            });

    } // End of displayItem()

    // Display the fetched data from API
    render() {
        var productHTMLList = [];

        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.oImageUrl, item.oName, item.oPrice);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and separate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
        }
    }

}   //End of ProductsController class