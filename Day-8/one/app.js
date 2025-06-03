const weatherData = {
  bhubaneswar: {
    date: 'Tuesday, 21 May 2025',
    temperature: '34°C',
    condition: 'Sunny',
    humidity: '45%',
    wind: '10 km/h',
    pressure: '1013 hPa',
    visibility: '10 km'
  },
  delhi: {
    date: 'Tuesday, 21 May 2025',
    temperature: '38°C',
    condition: 'Hot',
    humidity: '30%',
    wind: '15 km/h',
    pressure: '1008 hPa',
    visibility: '8 km'
  },
  london: {
    date: 'Tuesday, 21 May 2025',
    temperature: '18°C',
    condition: 'Rainy',
    humidity: '85%',
    wind: '20 km/h',
    pressure: '1015 hPa',
    visibility: '6 km'
  },
  tokyo: {
    date: 'Tuesday, 21 May 2025',
    temperature: '22°C',
    condition: 'Cloudy',
    humidity: '65%',
    wind: '12 km/h',
    pressure: '1012 hPa',
    visibility: '9 km'
  }
};

// DOM elements
const input = document.querySelector('.search-input');
const cityElem = document.querySelector('.city');
const dateElem = document.querySelector('.date');
const tempElem = document.querySelector('.temperature');
const descElem = document.querySelector('.description');
const iconElem = document.querySelector('.weather-icon');
const details = document.querySelectorAll('.right .detail');

// Event listener
input.addEventListener('keypress', function (e) {
  if (e.key === 'Enter') {
    const cityInput = input.value.trim().toLowerCase();
    const cityData = weatherData[cityInput];

    if (cityData) {
      cityElem.textContent = cityInput.charAt(0).toUpperCase() + cityInput.slice(1);
      dateElem.textContent = cityData.date;
      tempElem.textContent = cityData.temperature;
      descElem.textContent = cityData.condition;
      iconElem.src = cityData.icon;

      details[0].innerHTML = `<strong>Humidity:</strong> ${cityData.humidity}`;
      details[1].innerHTML = `<strong>Wind:</strong> ${cityData.wind}`;
      details[2].innerHTML = `<strong>Pressure:</strong> ${cityData.pressure}`;
      details[3].innerHTML = `<strong>Visibility:</strong> ${cityData.visibility}`;
    } else {
      alert('City not found. Try Bhubaneswar, Delhi, London, or Tokyo.');
    }

    input.value = ''; 
  }
});
