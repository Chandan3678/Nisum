function openproductreview() {
  const modal = document.getElementById("productmodal");
  const textarea = modal.querySelector("textarea");
  textarea.value = "";
  modal.style.display = "block";
}
function closeproductreview() {
  document.getElementById("productmodal").style.display = "none";
}
function submitproductreview() {
  const feedback = document.getElementById("reviewText").value;
  if (!feedback.trim() ) {
    alert("Please provide a review.");
    return;
  }
  alert(`Feedback Submited`);
  closeproductreview();
}


function openModal(modalId) {
  document.getElementById(modalId).style.display = "block";
}

function closeModal(modalId) {
  document.getElementById(modalId).style.display = "none";
}

function confirmBuyAgain() {
  alert("Your order has been placed again.");
  closeModal('buyAgainModal');
}
