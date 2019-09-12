# Backend Universal Conventions

<h4>Horizontally Scalable</h4>
<p>The backend is designed to be horizontally scalable. As such, the backend file-structure system must be coordinated in order to maintain its integrity. Each new feature folder must have the following folders (Note this is something a Dev-Ops team would automate):<p>
  <ul>
    <li>
      /NAME/_application
      <ul>
        <li>/NAME/_handlers</li>
        <li>/NAME/_agents</li>
      </ul>
    </li>
    <li>
      /NAME/_domain
      <ul>
        <li>/NAME/_service_cluster</li>
        <li>/NAME/DB_Direct-Access_Service-Proxy</li>
        <li>/NAME/DB</li>
      </ul>
    </li>
  </ul>
