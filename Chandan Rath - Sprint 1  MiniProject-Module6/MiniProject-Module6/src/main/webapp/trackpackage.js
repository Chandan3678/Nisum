// Updated to handle dynamic content and edge cases
document.addEventListener('DOMContentLoaded', function() {
  // Event delegation for Track Package button
  document.addEventListener('click', function(e) {
    if (e.target.closest('.button-group button:nth-child(2)')) {
      trackPackage();
    }
    if (e.target.id === 'contactAgentBtn') {
      contactAgent();
    }
  });
});

function trackPackage() {
  const modal = document.getElementById("trackModal");
  const body = document.getElementById("modalBody");
  
  if (!window.shipmentStatus) {
    console.error("Shipment status not loaded. Reload the page.");
    return;
  }

  const status = shipmentStatus.toLowerCase().trim();
  let html = '';

  if (status.includes("delivered")) {
    html = `
      <div style="text-align: center;">
        <h2>DELIVERED</h2>
        <img src="media/delivered.gif" style="width: 80%; max-width: 600px;">
      </div>`;
  } 
  else if (status.includes("transit")) {
    html = `
      <div style="text-align: center;">
        <h2>IN TRANSIT</h2>
        <img src="media/transit.jpg" style="width: 80%; max-width: 600px;">
      </div>`;
  } 
  else {
    html = `
      <div style="text-align: center;">
        <h2>Out for Delivery</h2>
        <img src="media/google-map-0d1ad8f5.jpg" style="width: 80%; max-width: 600px;">
        <br><br>
        <button id="contactAgentBtn" style="padding: 10px 20px; background: #007BFF; color: white; border: none; border-radius: 5px;">
          Contact Delivery Agent
        </button>
      </div>`;
  }

  body.innerHTML = html;
  modal.style.display = "block";
}

function contactAgent() {
  alert("Calling delivery agent...");
}

// Close modal when clicking outside
window.onclick = function(e) {
  if (e.target === document.getElementById('trackModal')) {
    e.target.style.display = 'none';
  }
};