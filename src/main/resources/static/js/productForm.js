const productsControl = new ProductsController();

var storeImage;

// When user clicks on 'List Product', calls API to add items to the database
// Add an 'onsubmit' event listener for productForm to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();

    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemImageUrl = document.querySelector('#imagefile');
    const newItemStyle = document.querySelector('#newItemStyle');
    const newItemPrice = document.querySelector('#newItemPrice');
    const newItemQuantity = document.querySelector('#newItemQuantity');


    // Get the values of the inputs - variable names to be same as MySQL columns
    const name = newItemNameInput.value;
    const description = newItemDescription.value;
    const imageUrl = "images/" + newItemImageUrl.value.replace("C:\\fakepath\\", "");
    const category = newItemCategory.value;
    const price = newItemPrice.value;
    const quantity = newItemQuantity.value;

    // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemImageUrl.value = '';
    newItemCategory.value = '';
    newItemPrice.value = '';
    newItemQuantity.value = '';

    // Add the task to the task manager
    productsControl.addItem(name, description, imageUrl, category, price, quantity, storeImage);
});

    // Select file input
    const input = document.querySelector('#imagefile');

    // Add event listener
    input.addEventListener('change', () => {
    storeImage = input.files[0];     // return the file object of the first file
    console.log("input: " + storeImage);
});

// Preview image before uploading
function previewFile(input) {
    var file = $("input[type=file]").get(0).files[0];

    if(file){
      var reader = new FileReader();

      reader.onload = function(){
          $("#previewImg").attr("src", reader.result);
      }

      reader.readAsDataURL(file);
    }
}