# Backend Universal Conventions

<h4>Horizontally Scalable</h4>
<p>The backend is designed to be horizontally scalable. As such, the backend file-structure system must be coordinated in order to maintain its integrity. Each new feature folder must have the following folders (Note this is something a Dev-Ops team would automate):<p>
  <ul>
    <li>
      NAME_application
      <ul>
        <li>NAME_handlers</li>
        <li>NAME_agents</li>
      </ul>
    </li>
    <li>
      NAME_domain
      <ul>
        <li>NAME_service_cluster</li>
        <li>NAMEDB_Direct-Access_Service-Proxy</li>
        <li>NAMEDB</li>
      </ul>
    </li>
   </ul>
